FROM adoptopenjdk/openjdk11

EXPOSE 8080

ARG JAR_FILE=target/kafka-consumer-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} kafka-consumer.jar

ENTRYPOINT ["java","-jar","kafka-consumer.jar"]
