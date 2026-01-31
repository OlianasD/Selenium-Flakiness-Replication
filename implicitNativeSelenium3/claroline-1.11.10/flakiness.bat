@echo off
setlocal enabledelayedexpansion

REM ======= Number of runs ==========
set n=50

for /L %%i in (1,1,%n%) do (
    echo.
    echo [RUN %%i OF %n%]

    echo Starting Claroline container...
    docker run -it --workdir=/home/claroline --name=claroline --expose 80 --expose 3306 -p 3000:80 -p 3306:3306 -d --entrypoint ./run-services-docker.sh olianasd/claroline-strongpsw bash

    timeout /t 5 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=Claroline_TestSuite test

    echo Saving results...
    mkdir "..\flakycheck\claroline-1.11.10\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\claroline-1.11.10\%%i\"

    echo Stopping and removing Docker containers...
    docker stop claroline >nul
    docker rm claroline >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= COMPLETATO =======
pause
