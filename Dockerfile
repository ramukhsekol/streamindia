FROM java:8
EXPOSE 8080
ADD /target/movies-0.0.1-SNAPSHOT.jar movies.jar 
ENTRYPOINT ["java", "-jar", "movies.jar"]