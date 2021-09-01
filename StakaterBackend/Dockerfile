FROM openjdk:8
ENV PORT 8001
EXPOSE 8001
COPY target/StakaterBackend-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -Dname=Arpit -Djava.security.egd=file:/dev/./urandom -jar  /app.jar 