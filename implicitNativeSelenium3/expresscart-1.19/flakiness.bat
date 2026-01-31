@echo off
setlocal enabledelayedexpansion

REM ======= NUMBER OF RUNS ==========
set n=50

for /L %%i in (1,1,%n%) do (
    echo.
    echo [RUN %%i OF %n%]

    echo Starting Expresscart container...
    docker run -i -t  --name=expresscart -p "3000:1111" -d olianasd/expresscart-strongpsw

    timeout /t 10 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test

    echo Saving results...
    mkdir "..\flakycheck\expresscart-1.19\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\flakycheck\expresscart-1.19\%%i\"

    echo Stopping and removing Docker containers...
    docker stop expresscart >nul
    docker rm expresscart >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= DONE =======
pause
