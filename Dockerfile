FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.war app.war

EXPOSE 5000

CMD ["java", "-jar", "app.war"]
