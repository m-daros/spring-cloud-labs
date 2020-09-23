FROM openjdk:8-jre-alpine
COPY ./target/service-provider-0.0.1-SNAPSHOT.jar /usr/src/service-provider/
WORKDIR /usr/src/service-provider
EXPOSE 8080
CMD ["java", "-jar", "service-provider-0.0.1-SNAPSHOT.jar"]