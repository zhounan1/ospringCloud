FROM openjdk:1.8
ADD ["-ospringCloud-provide-1.0-SNAPSHOT.jar","web.jar"]
EXPOSE 8090
ENTRYPOINT ["java","-jar","/web.jar"]