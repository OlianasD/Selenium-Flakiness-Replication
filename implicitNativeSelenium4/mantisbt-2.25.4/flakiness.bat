@echo off
setlocal enabledelayedexpansion

REM ======= NUMBER OF RUNS ==========
set n=50


for /L %%i in (1,1,%n%) do (
    echo.
    echo [RUN %%i OF %n%]

    echo Starting MantisBT containers...
    docker compose up -d

    timeout /t 10 /nobreak >nul

    echo Installing MantisBT...
    mvn -Dtest=Installer test

    timeout /t 5 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test
    timeout /t 5 /nobreak >nul
    
    echo Saving results...
    mkdir "..\flakycheck\mantisbt-2.25.4\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\mantisbt-2.25.4\%%i\"

    echo Stopping and removing Docker containers...
    docker stop mantisbt-2254-mantisbt-1 >nul
    docker rm mantisbt-2254-mantisbt-1 >nul
    docker stop mantisbt-2254-mysql-1 >nul
    docker rm mantisbt-2254-mysql-1 >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
