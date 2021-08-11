FROM openjdk:11-jre-slim

EXPOSE 8080

ADD /target/flight-app-0.0.1-SNAPSHOT.jar flight-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","flight-app-0.0.1-SNAPSHOT.jar"]