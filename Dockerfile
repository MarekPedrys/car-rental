FROM openjdk:11
ADD target/car-rental-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar car-rental-0.0.1-SNAPSHOT.jar
