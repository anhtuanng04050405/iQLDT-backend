FROM tomcat:9.0-jdk11-openjdk
COPY dist/iQLDT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
