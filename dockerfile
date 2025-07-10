# 🔧 Fase 1: build con Maven e Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia tutto il progetto nel container
COPY . .

# Compila il progetto e crea il JAR (senza test)
RUN mvn clean package -DskipTests

# 🚀 Fase 2: esecuzione con Java 21
FROM eclipse-temurin:21-jdk-alpine AS runtime
WORKDIR /app

# Copia il JAR generato dallo stage di build
COPY --from=build /app/target/*.jar app.jar

# Avvia l'app Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
