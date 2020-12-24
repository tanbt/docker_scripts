# A minimal base image for building a Scala project using `sbt.

## Includes

- [Alpine 3.9.4, openjdk version1.8.0_212](https://hub.docker.com/_/openjdk?tab=tags&page=1&ordering=last_updated&name=8u212-jre-alpine)
- sbt native package [1.0.0-M4](http://dl.bintray.com/sbt/native-packages/sbt/)

[CLICK HERE](https://hub.docker.com/r/tanbui/scala-play) to see how to use this image for deploying a Scala / Play framework project.

## Instruction

Build the image:

```
docker build -t tanbui/scala-sbt:1.0.0 .
```

Test the container:

```
docker run --name sb -it tanbui/scala-sbt:1.0.0 /bin/bash
```

Inside the container bash, run

```
sbt -version
```
