FROM java:openjdk-8-jre-alpine
ADD target/scala-2.12/mailsender-scala.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]