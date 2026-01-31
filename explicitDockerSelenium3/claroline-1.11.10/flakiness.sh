#!/bin/bash

# ======= NUMBER OF RUNS ==========
n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[RUN $i OF $n]"

    echo "Starting browser container..."
    docker run -d \
        -p 4444:4444 \
        -p 7900:7900 \
        --shm-size="2g" \
        --name browser \
        selenium/standalone-chrome:127.0-chromedriver-127.0

    sleep 5

    echo "Starting Claroline container..."
    docker run -it \
        --workdir=/home/claroline \
        --name claroline \
        --expose 80 \
        --expose 3306 \
        -p 3000:80 \
        -p 3306:3306 \
        -d \
        --entrypoint ./run-services-docker.sh \
        olianasd/claroline-strongpsw \
        bash

    sleep 5

    echo "Running tests with Maven..."
    mvn -Dtest=Claroline_TestSuite test

    echo "Saving results..."
    mkdir -p "../flakycheck/claroline-1.11.10/$i"
    cp -r target/surefire-reports/* "../flakycheck/claroline-1.11.10/$i/"

    echo "Stopping and removing Docker containers..."
    docker stop browser
    docker rm browser
    docker stop claroline
    docker rm claroline

    sleep 5
done

echo
echo "======= DONE ======="
read -p "Press Enter to exit..."