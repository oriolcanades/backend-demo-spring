# temp build
FROM docker.io/gradle:8.13.0 AS temp_build
ARG SKIP_TESTS=true
COPY build.gradle settings.gradle /home/gradle/src/
COPY src /home/gradle/src/src
COPY gradle /home/gradle/src/gradle
WORKDIR /home/gradle/src
RUN if [ "$SKIP_TESTS" = "true" ]; then \
    gradle build --no-daemon -x test; \
  else \
    gradle build --no-daemon; \
  fi

# build image
FROM bellsoft/liberica-openjdk-alpine-musl:21
RUN addgroup -S nonroot \
    && adduser -S nonroot -G nonroot
USER nonroot
WORKDIR /app
COPY --from=temp_build /home/gradle/src/build/libs/*.jar /app/issuer.jar
ENTRYPOINT ["java", "-jar", "/app/issuer.jar"]
