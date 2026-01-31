#!/bin/bash

# ======= NUMBER OF RUNS ==========
n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[RUN $i OF $n]"

    echo "Starting Bludit container..."
    docker run -d \
        --name bludit \
        -p 8080:80 \
        bludit/docker:3.13.1

    sleep 10

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    echo "Saving results..."
    mkdir -p "../flakycheck/bludit-3.13.1/$i"
    cp -r target/surefire-reports/* "../flakycheck/bludit-3.13.1/$i/"

    echo "Stopping and removing Docker containers..."
    docker stop bludit
    docker rm bludit

    sleep 5
done

echo
echo "======= DONE ======="
read -p "Press Enter to exit..."
