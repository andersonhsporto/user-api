FROM maven:3.8.6-eclipse-temurin-19-alpine AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests


FROM eclipse-temurin:19-jdk-alpine
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
COPY --from=build /project/target/user-api-0.0.1-SNAPSHOT.jar /app/user-api-0.0.1-SNAPSHOT.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
CMD "java" "-jar" "user-api-0.0.1-SNAPSHOT.jar"