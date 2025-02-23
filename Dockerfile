FROM amazoncorretto:21-alpine-jdk AS BUILDER
WORKDIR /app

COPY . .

RUN ./mvnw clean package

FROM amazoncorretto:21-alpine-jdk
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]