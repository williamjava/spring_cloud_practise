FROM java:8
VOLUME /tmp
ADD star-compute-service-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
##EXPOSE 52099
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
