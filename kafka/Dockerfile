FROM openjdk:17-bullseye

WORKDIR /app

ARG JAR_FILE=build/libs/kafka-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /app/producer-app.jar

ENTRYPOINT ["java", "-jar", "producer-app.jar"]
