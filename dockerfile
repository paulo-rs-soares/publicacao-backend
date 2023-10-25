FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install maven -y
COPY . .

RUN apt-get install openjdk-17-jdk -y
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/backend-1.0.0-SNAPSHOT-runner.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
