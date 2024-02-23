FROM openjdk:17-oracle

EXPOSE 8080

ADD build/libs/SB2REST-0.0.1-SNAPSHOT.jar dockerApp.jar

CMD ["java", "-jar", "dockerApp.jar"]