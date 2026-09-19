FROM tomcat:10.1-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN rm -rf /usr/local/tomcat/webapps/ROOT.war

COPY dist/iQLDT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
