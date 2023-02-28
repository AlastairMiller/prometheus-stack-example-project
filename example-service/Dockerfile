FROM openjdk:21-slim
EXPOSE 8080
ARG APP_JAR
ADD $APP_JAR exampleApp.jar
ENTRYPOINT ["java", "-jar", "exampleApp.jar"]