#!/bin/bash


# ======= NUMBER OF RUNS ==========
n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[RUN $i OF $n]"

    echo "Starting Expresscart container..."
    docker run -d \
        -p 3000:1111 \
        --name=expresscart \
        olianasd/expresscart-strongpsw

    sleep 10

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    echo "Saving results..."
    mkdir -p "../flakycheck/expresscart-1.19/$i"
    cp -r target/surefire-reports/* "../flakycheck/expresscart-1.19/$i/"

    echo "Stopping and removing Docker containers..."
    docker stop expresscart
    docker rm expresscart

    sleep 5
done

echo
echo "======= DONE ======="
