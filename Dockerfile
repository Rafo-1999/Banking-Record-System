FROM openjdk

EXPOSE 8080

ADD target/banking-record-system.jar banking-record-system.jar

ENTRYPOINT ["java","-jar","/banking-record-system.jar"]

