FROM openjdk:11
WORKDIR eureka-service/src
ADD ./target/eureka-service-0.0.1-SNAPSHOT.jar app2.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","app2.jar"]