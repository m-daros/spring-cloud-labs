FROM openjdk:8-jre-alpine
COPY ./target/service-client-0.0.1-SNAPSHOT.jar /usr/src/service-client/
WORKDIR /usr/src/service-client
EXPOSE 8080
CMD ["java", "-jar", "service-client-0.0.1-SNAPSHOT.jar"]