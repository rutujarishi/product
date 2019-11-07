FROM openjdk:11
WORKDIR config-service/src
ADD ./target/config-service-0.0.1-SNAPSHOT.jar app3.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","app3.jar"]