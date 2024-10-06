# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Copy the runnable JAR file from the build stage
COPY --from=build /app/target/practice-0.0.1-SNAPSHOT.jar /app/app.jar

# Set the command to run the application
CMD ["java", "-jar", "/app/app.jar"]
