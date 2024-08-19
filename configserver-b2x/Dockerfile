#Start with a base image
FROM openjdk:17-jdk-slim as built

MAINTAINER siferga.com

#Add app's jar to container
COPY target/configserver-b2x-0.0.1-SNAPSHOT.jar configserver-b2x-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/configserver-b2x-0.0.1-SNAPSHOT.jar"]
