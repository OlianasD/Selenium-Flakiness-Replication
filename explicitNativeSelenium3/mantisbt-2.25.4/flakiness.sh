#!/bin/bash


# ======= NUMBER OF RUNS ==========
n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[RUN $i OF $n]"

    echo "Starting MantisBT containers..."
    docker compose up -d

    sleep 10

    echo "Installing MantisBT..."
    mvn -Dtest=Installer test

    sleep 5

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    sleep 5

    echo "Saving results..."
    mkdir -p "../flakycheck/mantisbt-2.25.4/$i"
    cp -r target/surefire-reports/* "../flakycheck/mantisbt-2.25.4/$i/"

    echo "Stopping and removing Docker containers..."

    docker stop mantisbt-2254-mantisbt-1
    docker rm mantisbt-2254-mantisbt-1

    docker stop mantisbt-2254-mysql-1
    docker rm mantisbt-2254-mysql-1

    sleep 5
done

echo
echo "======= DONE ======="