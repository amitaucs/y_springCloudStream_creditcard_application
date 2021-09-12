FROM adoptopenjdk
EXPOSE 8006
ADD target/creditCardApplication-1.0.0.jar  creditCardApplication.jar
ENTRYPOINT [ "java", "-jar", "/creditCardApplication.jar"]
