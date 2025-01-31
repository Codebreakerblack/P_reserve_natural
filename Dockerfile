# Usa una imagen de Java 21
FROM eclipse-temurin:21-jdk

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR generado por Maven al contenedor
COPY target/P_reserve_natural-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (el que usa Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]

