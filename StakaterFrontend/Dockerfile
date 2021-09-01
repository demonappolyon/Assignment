FROM openjdk:8
ENV PORT 8001
EXPOSE 8001
RUN mkdir /usr/StakaterFrontend
ENV StakaterFrontend_FILE StakaterFrontend-0.0.1-SNAPSHOT.jar
ENV StakaterFrontend_HOME /usr/StakaterFrontend
COPY target/$StakaterFrontend_FILE $StakaterFrontend_HOME/
WORKDIR $StakaterFrontend_HOME
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Djava.security.egd=file:/dev/./urandom -jar -Dspring.config.location=/config/application.properties $StakaterFrontend_FILE"]
