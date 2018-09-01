FROM java:8
MAINTAINER c.avendano10@gmail.com
VOLUME /tmp
ADD user-service.jar app.jar
ADD wait-for-mysql.sh wait.sh
RUN bash -c 'chmod +x /wait.sh'
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["/bin/bash", "./wait.sh"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]
