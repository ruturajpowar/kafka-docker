FROM adoptopenjdk/openjdk11

EXPOSE 8080

ARG JAR_FILE=target/kafka-producer-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} kafka-producer.jar

ENTRYPOINT ["java","-jar","kafka-producer.jar"]
