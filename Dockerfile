# ===============================
# Build stage
# ===============================
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package


# ===============================
# Run stage
# ===============================
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.war app.war

EXPOSE 8080

CMD ["java", "-jar", "app.war"]
