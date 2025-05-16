FROM openjdk:17
VOLUME /tmp
COPY target/movie-booking-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
