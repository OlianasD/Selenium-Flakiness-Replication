@echo off
setlocal enabledelayedexpansion

REM ======= NUMBER OF RUNS ==========
set n=50

for /L %%i in (1,1,%n%) do (
    echo.
    echo [RUN %%i OF %n%]

    echo Starting Joomla container...
    docker run -i -t  --name=joomla -p "3000:80" -d olianasd/joomla4stile

    timeout /t 10 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test

    echo Saving results...
    mkdir "..\flakycheck\joomla-4.2.0\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\joomla-4.2.0\%%i\"

    echo Stopping and removing Docker containers...
    docker stop joomla >nul
    docker rm joomla >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
