FROM maven:3.9.9-eclipse-temurin-21 AS dev

WORKDIR /app

# Copy pom.xml and download dependencies first (caches Maven deps if code changes later)
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
COPY .mvn ./.mvn
COPY checkstyle-suppressions.xml ./checkstyle-suppressions.xml

RUN mvn compile



FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml and download dependencies first (caches Maven deps if code changes later)
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
COPY .mvn ./.mvn
COPY checkstyle-suppressions.xml ./checkstyle-suppressions.xml

RUN mvn clean package -DskipTests



FROM eclipse-temurin:21-jre AS runtime

WORKDIR /app

COPY --from=build /app/target/my-app-*.jar app.jar

ENTRYPOINT ["java", "-cp", "app.jar", "com.mycompany.app.App"]
