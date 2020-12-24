# Deploy a simple Rest API using Play framework with Docker

## Includes

- [Scala sbt](https://hub.docker.com/r/tanbui/scala-sbt)
- A simple Play framework 2.8 app with a REST API

## Instruction

Build the image

```
docker build -t tanbui/scala-play:1.0.0 .
```

Run the container

```
docker run --name sp -d -p 9000:9000 tanbui/scala-play:1.0.0
```

Test at: http://localhost:9000/v1/hello
