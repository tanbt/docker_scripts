# Docker Script

Dockerfile and scripts for Web Environment

## 12/2020

### scala_sbt

This is a base image for build or run a scala app in prodution using [sbt](https://www.scala-sbt.org/).

`openjdk:8u212-jre-alpine` has the minimal image size. Some other base images can be found in [openjdk images](https://hub.docker.com/_/openjdk?tab=tags&page=1&ordering=last_updated).

`sbt` versions can be found [here](http://dl.bintray.com/sbt/native-packages/sbt/).

## Before 2018

These images are quite old and not recommend to use. Some scripts maybe still useful.

- **ubuntu_base**: Ubuntu 18.04LTS with some basic tools and settings, support timezone parameter.
- **apache_php7_supervisor**: Supervisord will manage Apache 2.4, which run php7 and mariadb
- **monbodb**: MongoDB 3.2 with external configuration file
