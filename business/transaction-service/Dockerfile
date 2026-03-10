FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /build

COPY . .

RUN mvn -pl business/transaction-service -am clean package -DskipTests


FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /build/business/transaction-service/target/*.jar app.jar

EXPOSE 8084

ENTRYPOINT ["java","-jar","app.jar"]