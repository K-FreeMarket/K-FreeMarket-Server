FROM amazoncorretto:21-alpine

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

# (로컬에 있는 파일을 Docker 이미지 안에 포함시킴)
COPY src/main/resources/properties/env.properties src/main/resources/properties/env.properties


ENTRYPOINT ["java", "-jar", "/app.jar"]
