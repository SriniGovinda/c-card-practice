FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /build

COPY . .

RUN mvn -pl platform/auth-service -am clean package -DskipTests


FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /build/platform/auth-service/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]