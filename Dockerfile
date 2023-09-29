FROM maven:latest AS build-stage
COPY . /build
WORKDIR /build
RUN mvn clean package

FROM openjdk:11 AS runtime
WORKDIR /opt/hello-world
COPY --from=build-stage /build/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
