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
        --name=browser \
        selenium/standalone-chrome:127.0-chromedriver-127.0

    sleep 5

    echo "Starting Prestashop containers..."
    docker run -d \
        --name some-mysql \
        --network prestashop-net \
        -e MYSQL_ROOT_PASSWORD=admin \
        -p 3307:3306 \
        mysql:5.7

    docker run -d \
        --name some-prestashop \
        --network prestashop-net \
        -e DB_SERVER=some-mysql \
        -p 8080:80 \
        prestashop/prestashop:1.7.8.5

    sleep 10

    echo "Installing Prestashop..."
    mvn -Dtest=Installer test

    echo "Deleting install directory and removing admin directory..."
    docker exec some-prestashop bash -c "rm -rf install"
    docker exec some-prestashop bash -c "mv admin administrator"

    sleep 5

    echo "Stopping onboarding..."
    mvn -Dtest=StopOnboarding test

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    sleep 5

    echo "Saving results..."
    mkdir -p "../flakycheck/prestashop-1.7.8.5/$i"
    cp -r target/surefire-reports/* "../flakycheck/prestashop-1.7.8.5/$i/"

    echo "Stopping and removing Docker containers..."
    docker stop browser
    docker rm browser

    docker stop some-prestashop
    docker rm some-prestashop

    docker stop some-mysql
    docker rm some-mysql

    sleep 5
done

echo
echo "======= DONE ======="