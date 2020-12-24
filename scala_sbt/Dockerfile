# Alpine 3.9.4, openjdk version "1.8.0_212"
# Build the image: `docker build -t tanbui/scala-sbt:1.0.0 .`
# Test the container:
#   `docker run --name sb -it tanbui/scala-sbt:1.0.0 /bin/bash`
#   # sbt -version

FROM openjdk:8u212-jre-alpine as base

ENV SCALA_VERSION=2.13.3 \
  SCALA_HOME=/usr/share/scala
ENV SBT_VERSION 1.0.0-M4

RUN apk update && apk upgrade
RUN apk add --no-cache bash curl && \
  curl -sL "http://dl.bintray.com/sbt/native-packages/sbt/$SBT_VERSION/sbt-$SBT_VERSION.tgz" | gunzip | tar -x -C /usr/local && \
  ln -s /usr/local/sbt/bin/sbt /usr/local/bin/sbt && \
  chmod 0755 /usr/local/bin/sbt
