FROM eclipse-temurin:21-jdk
COPY "./target/EJERCICIOSPRING-1.jar" "app.jar"
EXPOSE 9090
ENTRYPOINT [ "java", "-jar", "app.jar" ]
