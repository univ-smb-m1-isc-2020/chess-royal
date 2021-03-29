FROM openjdk:11-jre-slim

COPY ./target/chess-royale-1.0-SNAPSHOT.jar .

EXPOSE 8080

CMD ["sh","-c","java -XX:InitialRAMPercentage=50 -XX:MaxRAMPercentage=70  -XshowSettings $JAVA_OPTS -jar chess-royale-1.0-SNAPSHOT.jar"]
