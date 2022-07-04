FROM 243587609515.dkr.ecr.us-east-1.amazonaws.com/openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE 8000
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
