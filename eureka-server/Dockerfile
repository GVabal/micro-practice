FROM openjdk:11.0.9-jre-slim

CMD gradle build

WORKDIR /app

COPY --from=build build/libs/*.jar /app/app.jar

EXPOSE 8761
ENTRYPOINT ["java","-jar","app.jar"]
