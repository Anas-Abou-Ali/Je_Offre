
#FROM apache-tomcat-9.0.43
#VOLUME /tmp
#ADD target/JEE_Project*.jar /app.jar
#CMD ["sh","startup.sh","/app.jar"]
#EXPOSE 8080


FROM tomcat:9.0
RUN adduser --disabled-login tomcat
RUN chown -R tomcat:tomcat /usr/local/tomcat
VOLUME /tmp
USER tomcat
COPY target/Offre-1.0-SNAPSHOT.war  /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]




#FROM jboss/wildfly
#COPY target/*.war /opt/jboss/wildfly/standalone/deployments/
#EXPOSE 8080


#docker build -t kingridda/joffrejee .
#&& docker run -p 127.0.0.1:8080:8080 --name JOffreJEEContainer kingridda/joffrejee


#tomcat:

