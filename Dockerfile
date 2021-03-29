FROM maven:3.6.3-openjdk-11-slim

RUN mkdir /usr/api-agenda-springboot
WORKDIR /usr/api-agenda-springboot

COPY . .

ENV MYSQL_SERVER_ADDRESS=
ENV MYSQL_USERNAME=
ENV MYSQL_PASSWORD=

RUN mvn clean install -U -DskipTests

WORKDIR target/

EXPOSE 8080

CMD ["java", "-jar", "agenda-0.0.1-SNAPSHOT.jar"]
