FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD build/libs/SB2REST-0.0.1-SNAPSHOT.jar dockerApp.jar

CMD ["java", "-jar", "dockerApp.jar"]