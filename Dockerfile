FROM adoptopenjdk/openjdk11-openj9:latest
RUN mkdir /opt/app
COPY target/DemoZup.jar /opt/app
CMD ["java", "-jar", "/opt/app/DemoZup.jar"]