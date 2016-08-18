FROM java:8-jre
MAINTAINER Hector Hurtado <hectorhuol@gmail.com>

ADD ./target/account-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/expenses-rest-api.jar"]

EXPOSE 8080