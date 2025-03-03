# Use a lightweight JDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Gradle build output (JAR file)
COPY build/libs/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
