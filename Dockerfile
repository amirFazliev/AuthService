FROM adoptopenjdk/openjdk8

EXPOSE 8080

ADD build/libs/AuthService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]