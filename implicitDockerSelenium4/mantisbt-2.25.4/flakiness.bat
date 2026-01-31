@echo off
setlocal enabledelayedexpansion

REM ======= NUMBER OF RUNS ==========
set n=50


for /L %%i in (1,1,%n%) do (
    echo.
    echo [RUN %%i OF %n%]

    echo Starting browser container...
    docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:127.0-chromedriver-127.0

    timeout /t 5 /nobreak >nul

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
    docker stop browser >nul
    docker rm browser >nul
    docker stop mantisbt-2254-mantisbt-1 >nul
    docker rm mantisbt-2254-mantisbt-1 >nul
    docker stop mantisbt-2254-mysql-1 >nul
    docker rm mantisbt-2254-mysql-1 >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
