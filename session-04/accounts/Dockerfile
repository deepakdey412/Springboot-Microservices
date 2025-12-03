# Start with a base image for Java
FROM eclipse-temurin:17-jdk-jammy

# Maintainer information
LABEL maintainer="deepakdey"

# Add the application JAR to image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Execute the Application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]
