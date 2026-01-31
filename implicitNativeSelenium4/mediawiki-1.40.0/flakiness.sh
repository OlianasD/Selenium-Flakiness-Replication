#!/bin/bash


# ======= NUMBER OF RUNS ==========
n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[RUN $i OF $n]"

    echo "Starting Mediawiki containers..."
    docker compose up -d

    sleep 15

    echo "Installing Mediawiki..."
    mvn -Dtest=Installer test

    echo "Copying LocalSettings.php..."
    docker cp LocalSettings.php mediawiki-1400-mediawiki-1:/var/www/html

    sleep 5

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    sleep 5

    echo "Saving results..."
    mkdir -p "../flakycheck/mediawiki-1.40.0/$i"
    cp -r target/surefire-reports/* "../flakycheck/mediawiki-1.40.0/$i/"

    echo "Stopping and removing Docker containers..."

    docker stop mediawiki-1400-mediawiki-1
    docker rm mediawiki-1400-mediawiki-1

    docker stop mediawiki-1400-database-1
    docker rm mediawiki-1400-database-1

    docker volume rm mediawiki-1400_images
    docker volume rm mediawiki-1400_db

    sleep 5
done

echo
echo "======= DONE ======="
