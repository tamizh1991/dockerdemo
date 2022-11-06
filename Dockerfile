FROM openjdk:11
EXPOSE 9100
ADD target/docker-demo.jar docker-demo.jar
ENTRYPOINT [ "java","-jar","/docker-demo.jar"]