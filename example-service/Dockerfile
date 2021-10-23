FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG APP_JAR
ADD $APP_JAR exampleApp.jar
ENTRYPOINT ["java", "-jar", "exampleApp.jar"]