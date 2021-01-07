FROM openjdk:11.0.9-jre-slim

ARG JAR_FILE=build/libs/*.jar

CMD gradle build

WORKDIR /app

COPY ${JAR_FILE} /app/app.jar

EXPOSE 8761
ENTRYPOINT ["java","-jar","app.jar"]
