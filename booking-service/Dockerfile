FROM openjdk:11
WORKDIR booking-service/src
ADD ./target/booking-service-1.0.0-SNAPSHOT.jar  app7.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","app7.jar"]