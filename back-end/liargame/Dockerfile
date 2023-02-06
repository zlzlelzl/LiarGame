FROM openjdk:11-jre

WORKDIR /root/***REMOVED***/back-end/liargame

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew build

COPY --from=builder build/libs/*.jar app.jar

EXPOSE 5000
ENTRYPOINT ["java","-jar","/app.jar"]
