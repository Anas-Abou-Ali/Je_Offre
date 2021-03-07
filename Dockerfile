FROM tomcat:9.0
RUN adduser --disabled-login tomcat
RUN chown -R tomcat:tomcat /usr/local/tomcat
VOLUME /tmp
USER tomcat
COPY target/Offre-1.0-SNAPSHOT.war  /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]

