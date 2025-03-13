#instancia la imagen
FROM openjdk:21-jdk-slim AS build
#copia de tarjet al contenedor
COPY target/hotels-0.0.1-SNAPSHOT.jar hotels-0.0.1-SNAPSHOT.jar
# ejecuta microservicio
ENTRYPOINT ["java","-jar","/hotels-0.0.1-SNAPSHOT.jar"]