FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/mycrm-0.0.1-SNAPSHOT.jar mycrm.jar
ENTRYPOINT ["java","-jar","/mycrm.jar"]