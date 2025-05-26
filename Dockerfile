FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/TriangleClassifier-1.0.0.jar TriangleClassifier.jar
CMD ["java", "-jar", "TriangleClassifier.jar"]

