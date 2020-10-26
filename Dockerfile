FROM java:8

EXPOSE 8081

ADD target/ProdShop-1.0-SNAPSHOT.jar ProdShop-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "ProdShop-1.0-SNAPSHOT.jar"]