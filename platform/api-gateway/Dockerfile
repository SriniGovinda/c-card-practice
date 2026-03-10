FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /build

COPY . .

RUN mvn -pl platform/api-gateway -am clean package -DskipTests


FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /build/platform/api-gateway/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]