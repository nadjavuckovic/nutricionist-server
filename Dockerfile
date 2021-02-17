FROM openjdk:11
ADD target/nutricionist-portal.jar nutricionist-portal.jar
EXPOSE 9002
ENTRYPOINT ["java", "-jar", "nutricionist-portal.jar"]
