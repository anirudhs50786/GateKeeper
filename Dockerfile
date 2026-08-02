FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create a non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy pre-built jar from host build output (prebuild.sh should produce these jars)
COPY build/libs/*.jar /app/app.jar
RUN chown appuser:appgroup /app/app.jar
USER appuser

EXPOSE 8063
ENV JVM_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "exec java $JVM_OPTS -jar /app/app.jar"]
