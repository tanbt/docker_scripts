# Build: `docker build -t tanbui/scala-play:1.0.0 .`
# Run: `docker run --name sp -d -p 9000:9000 tanbui/scala-play:1.0.0`
# Test: http://localhost:9000/v1/hello

# Prepare the env
FROM tanbui/scala-sbt:1.0.0 as base

# Copy source to /source directory
RUN mkdir /source
COPY . /source

# Build the app
WORKDIR /source
RUN sbt dist

# Deploy to a new image
FROM openjdk:8u212-jre-alpine
RUN apk update && apk upgrade && apk --no-cache add zip bash && \
  mkdir /app

COPY --from=base /source/target/universal/scala_play-1.0-SNAPSHOT.zip /app
WORKDIR /app
RUN unzip scala_play-1.0-SNAPSHOT.zip
CMD ["/app/scala_play-1.0-SNAPSHOT/bin/scala_play"]
