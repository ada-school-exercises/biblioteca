FROM gradle:8.10.1-jdk21 AS build

WORKDIR /app

COPY . .

RUN gradle build --no-daemon

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/biblioteca-0.0.1-SNAPSHOT.jar .
COPY --from=build /app/src/main/resources/application.properties .

EXPOSE 8080

CMD ["java", "-jar", "biblioteca-0.0.1-SNAPSHOT.jar"]