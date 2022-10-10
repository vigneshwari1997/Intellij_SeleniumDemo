FROM openjdk:18
COPY /target/test-classes/com/ /tmp
WORKDIR /tmp
CMD java com.allure.example.runners.Run