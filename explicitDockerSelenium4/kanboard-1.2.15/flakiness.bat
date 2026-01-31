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

    echo Starting Kanboard container...
    docker run -d --name kanboard -p 8080:80 -t kanboard/kanboard:v1.2.15

    timeout /t 10 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test

    echo Saviung results...
    mkdir "..\flakycheck\kanboard-1.2.15\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\kanboard-1.2.15\%%i\"

    echo Stopping and removing Docker containers...
    docker stop browser >nul
    docker rm browser >nul
    docker stop kanboard >nul
    docker rm kanboard >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
