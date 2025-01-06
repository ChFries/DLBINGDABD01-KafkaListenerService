# HOW TO RUN

These instructions are for linux only. Most of it should be similar for windows users

## Install Docker

Follow the instructions detailed on https://docs.docker.com/engine/install/ubuntu/ to install Docker on your local host machine

## Checkout Source Code

In an IDE of your choice checkout the source code located at https://github.com/ChFries/DLBINGDABD01-KafkaListenerService.git

In Intellij Idea for Example: Goto File -> New -> Project from Version Control -> Paste URL into URL-Field

## Installing Dependencies

In a terminal, navigate to root folder of the project then run

`mvn clean install`

if you haven't got maven installed run

`./mvnw clean install`

instead

This will download all required packages from maven-central and compile runnable jars in the /target folder

## Create a DockerImage from the Jars

This will build an executable DockerImage from the Project

`sudo docker build -t dlbingdab01/kafka-listener-service .`

## Get KafkaBroker

This will download a runnable DockerImage for a KafkaBroker

`sudo docker pull apache/kafka-native:3.9.0`

## Get Redis

`sudo docker pull redis:latest`

## Run the prototype

To run the prototype you have to

Run the KafkaBroker by typing:

`docker run -d -p 9092:9092 apache/kafka-native:3.9.0`

Run the Redis-Database by typing:

`docker run -d -p 6379:6379 redis`

Run the MockPublisher by typing:

`docker run --network host  -d -p 8081:8081 -e "SPRING_PROFILES_ACTIVE=local, producer" dlbingdab01/kafka-listener-service`

Run the ListenerService by typing:

`docker run --network host -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=local, listener" dlbingdab01/kafka-listener-service`

## Check if everything works

You should see logs being written to the terminal of the kafka-listener-service

when directing to http://localhost:8080 or http://localhost:8080/aggregated-data you should see a response from the Microservice

Alternatively you can run

`curl localhost:8080`
or
`curl localhost:8080/aggregated-data`
