# 1. Use an official Tomcat image with Java 11
FROM tomcat:9-jdk11

# 2. Remove default Tomcat apps (optional but clean)
RUN rm -rf /usr/local/tomcat/webapps/*

# 3. Copy your WAR file into Tomcat's webapps folder
COPY ./target/techaj.war /usr/local/tomcat/webapps/techaj.war

# 4. Expose port 8080
EXPOSE 8080

# 5. Start Tomcat server
CMD ["catalina.sh", "run"]

