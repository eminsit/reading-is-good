FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]