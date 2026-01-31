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

    echo Starting Joomla container...
    docker run -i -t  --name=joomla -p "3000:80" -d olianasd/joomla4stile

    timeout /t 10 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test

    echo Saving results...
    mkdir "..\flakycheck\joomla-4.2.0\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\joomla-4.2.0\%%i\"

    echo Stopping and removing Docker containers...
    docker stop browser >nul
    docker rm browser >nul
    docker stop joomla >nul
    docker rm joomla >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
