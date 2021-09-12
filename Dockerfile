FROM adoptopenjdk
EXPOSE 8006
ADD target/creditCardApplication-1.0.0.jar  creditCardApplication.jar
ENV MSQL_HOSTNAME=mysql
ENV RMQ_HOSTNAME=rabbitmq
ENTRYPOINT [ "java", "-jar", "/creditCardApplication.jar"]
