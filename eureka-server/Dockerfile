FROM openjdk:11.0.9-jre-slim

CMD gradle build

COPY build/libs/*.jar app.jar

EXPOSE 8761
ENTRYPOINT ["java","-jar","app.jar"]
