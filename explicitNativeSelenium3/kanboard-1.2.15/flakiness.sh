#!/usr/bin/env bash

set -e

# ======= NUMBER OF RUNS ==========
n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[RUN $i OF $n]"

    echo "Starting Kanboard container..."
    docker run -d \
        --name kanboard \
        -p 8080:80 \
        kanboard/kanboard:v1.2.15

    sleep 10

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    echo "Saving results..."
    mkdir -p "../flakycheck/kanboard-1.2.15/$i"
    cp -r target/surefire-reports/* "../flakycheck/kanboard-1.2.15/$i/"

    echo "Stopping and removing Docker containers..."
    docker stop kanboard
    docker rm kanboard

    sleep 5
done

echo
echo "======= DONE ======="
