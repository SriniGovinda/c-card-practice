# -------- build stage --------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /build

COPY . .

RUN mvn -pl business/payment-service -am clean package -DskipTests

# -------- run stage --------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /build/business/payment-service/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]