FROM openjdk:11
WORKDIR zuul-service/src
ADD ./target/zuul-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar", "app.jar"]