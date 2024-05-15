# Используем базовый образ с Java и Maven для сборки приложения
FROM maven:3.8.4-openjdk-17 AS builder

# Копируем файлы проекта и устанавливаем зависимости Maven
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код проекта
COPY src/ ./src/

# Собираем приложение
RUN mvn package -DskipTests

# Используем базовый образ с Java для запуска приложения
FROM openjdk:17-slim

# Копируем JAR-файл из сборщика в контейнер
COPY --from=builder /app/target/The-toss-of-coin-0.0.1-SNAPSHOT.jar /app/app.jar

# Определяем порт, который будет доступен из контейнера
EXPOSE 8080

# Команда для запуска приложения Spring Boot
CMD ["java", "-jar", "/app/app.jar"]
