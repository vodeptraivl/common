FROM tomcat:9.0.48-jdk11-openjdk

COPY ./build/libs/ROOT.war /usr/local/tomcat/webapps