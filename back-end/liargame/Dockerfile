FROM openjdk:11-jdk

# WORKDIR /root/***REMOVED***/back-end/liargame

COPY ./ ./
RUN chmod +x ./gradlew
RUN ./gradlew clean build --no-daemon

#RUN chmod +x ./gradlew
#RUN ./gradlew cleanQuerydslSourcesDir
#RUN ./gradlew build

#COPY --from=builder build/build/libs/*.jar .

EXPOSE 5000
#CMD ["java", "-jar", "./*.jar"]
ENTRYPOINT ["java", "-jar", "./build/libs/liargame-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java","-jar","*.jar"]
