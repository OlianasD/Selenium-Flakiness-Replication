@echo off
setlocal enabledelayedexpansion

REM ======= NUMBER OF RUNS ==========
set n=50

for /L %%i in (1,1,%n%) do (
    echo.
    echo [RUN %%i OF %n%]

    echo Starting Mediawiki containers...
    docker compose up -d

    timeout /t 15 /nobreak >nul

    echo Installing Mediawiki...
    mvn -Dtest=Installer test

    echo Copying LocalSettings.php...
    docker cp LocalSettings.php mediawiki-1400-mediawiki-1:/var/www/html

    timeout /t 5 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test
    timeout /t 5 /nobreak >nul

    echo Saving results...
    mkdir "..\flakycheck\mediawiki-1.40.0\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\mediawiki-1.40.0\%%i\"

    echo Stopping and removing Docker containers...
    docker stop mediawiki-1400-mediawiki-1 >nul
    docker rm mediawiki-1400-mediawiki-1 >nul
    docker stop mediawiki-1400-database-1 >nul
    docker rm mediawiki-1400-database-1 >nul
    docker volume rm mediawiki-1400_images >nul
    docker volume rm mediawiki-1400_db >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
