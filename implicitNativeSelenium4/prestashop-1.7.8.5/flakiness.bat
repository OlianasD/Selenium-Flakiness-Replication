@echo off
setlocal enabledelayedexpansion

REM ======= NUMBER OF RUNS ==========
set n=50

for /L %%i in (1,1,%n%) do (
    echo.
    echo [RUN %%i OF %n%]

    echo Starting Prestashop containers...
    docker run -ti --name some-mysql --network prestashop-net -e MYSQL_ROOT_PASSWORD=admin -p 3307:3306 -d mysql:5.7
    docker run -ti --name some-prestashop --network prestashop-net -e DB_SERVER=some-mysql -p 8080:80 -d prestashop/prestashop:1.7.8.5

    timeout /t 10 /nobreak >nul

    echo Installing Prestashop...
    mvn -Dtest=Installer test

    echo Removing install directory and renaming admin directory...
    docker exec some-prestashop bash -c "rm -rf install"
    docker exec some-prestashop bash -c "mv admin administrator"

    timeout /t 5 /nobreak >nul

    echo Closing app onboarding...
    mvn -Dtest=StopOnboarding test

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test

    timeout /t 5 /nobreak >nul

    echo Saving results...
    mkdir "..\flakycheck\prestashop-1.7.8.5\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\prestashop-1.7.8.5\%%i\"

    echo Stopping and removing Docker containers...
    docker stop some-prestashop >nul
    docker rm some-prestashop >nul
    docker stop some-mysql >nul
    docker rm some-mysql >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
