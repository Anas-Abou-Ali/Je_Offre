
#FROM apache-tomcat-9.0.43
#VOLUME /tmp
#ADD target/JEE_Project*.jar /app.jar
#CMD ["sh","startup.sh","/app.jar"]
#EXPOSE 8080


FROM tomcat:9.0
VOLUME /tmp
COPY target/Offre-1.0-SNAPSHOT  /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]




#FROM jboss/wildfly
#COPY target/*.war /opt/jboss/wildfly/standalone/deployments/
#EXPOSE 8080


#docker build -t kingridda/joffrejee .
#&& docker run -p 127.0.0.1:8080:8080 --name JOffreJEEContainer kingridda/joffrejee


#tomcat:

