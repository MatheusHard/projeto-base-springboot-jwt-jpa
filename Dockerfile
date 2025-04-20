# Etapa 1: build com Maven + Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copia o projeto para dentro do container
COPY . .

# Dá permissão ao wrapper e compila
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Etapa 2: imagem leve só com o JAR pronto
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Comando para rodar o app
CMD ["java", "-jar", "app.jar"]
