FROM maven:3.6.3-openjdk-11
WORKDIR /usr/src/app/plates-backend

COPY ./ /usr/src/app/plates-backend
EXPOSE 8090/tcp
ENTRYPOINT ["mvn", "spring-boot:run"]