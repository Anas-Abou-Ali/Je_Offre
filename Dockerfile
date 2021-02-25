
#FROM apache-tomcat-9.0.43
#VOLUME /tmp
#ADD target/JEE_Project*.jar /app.jar
#CMD ["sh","startup.sh","/app.jar"]
#EXPOSE 8080


#FROM tomcat:9.0-alpine
#VOLUME /tmp
#COPY target/*.war  /usr/local/tomcat/webapps
#EXPOSE 8080
#CMD ["catalina.sh","run"]


FROM tomcat:9.0-alpine
VOLUME /tmp
COPY target/*.war  /usr/local/tomcat/webapps
EXPOSE 8080

#FROM jboss/wildfly
#COPY target/*.war /opt/jboss/wildfly/standalone/deployments/


#docker build -t kingridda/JOffreJEEImg:1.0 .
#
#
#docker run kingridda/JOffreJEEImg:1.0
#-p 127.0.0.1:8080:8080
#--name JOffreJEEContainer



#tomcat:latest

