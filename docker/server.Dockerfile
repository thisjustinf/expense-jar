FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ./server/target/server-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java","-jar","./server/target/server-0.0.1-SNAPSHOT.jar"]