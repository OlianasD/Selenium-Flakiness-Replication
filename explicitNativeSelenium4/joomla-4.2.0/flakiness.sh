#!/bin/bash


# ======= NUMBER OF RUNS ==========
n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[RUN $i OF $n]"

    echo "Starting Joomla container..."
    docker run -d \
        -p 3000:80 \
        --name=joomla \
        olianasd/joomla4stile

    sleep 10

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    echo "Saving results..."
    mkdir -p "../flakycheck/joomla-4.2.0/$i"
    cp -r target/surefire-reports/* "../flakycheck/joomla-4.2.0/$i/"

    echo "Stopping and removing Docker containers..."
    docker stop joomla
    docker rm joomla

    sleep 5
done

echo
echo "======= DONE ======="
