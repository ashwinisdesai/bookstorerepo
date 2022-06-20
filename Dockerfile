FROM openjdk:8-jdk-alpine AS builder
WORKDIR source
ARG JAR_FILE=./target/bookstore-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} bookstore.jar
EXPOSE 8080
RUN java -Djarmode=layertools -jar bookstore.jar extract
