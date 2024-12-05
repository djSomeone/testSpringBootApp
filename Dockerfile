FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package
FROM eclipse-temurin:17-alpine
COPY --from=build /target/*.jar demo.jar
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","demo.jar"]
