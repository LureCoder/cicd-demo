# 基础镜像（Java 17）
FROM eclipse-temurin:17-jre-alpine
# 复制打包后的 Jar 包到镜像
COPY target/*.jar app.jar
# 暴露端口（Spring Boot 默认 8080）
EXPOSE 8081
# 启动命令
ENTRYPOINT ["java", "-jar", "/app.jar"]