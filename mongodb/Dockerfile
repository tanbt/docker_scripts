# Build command
#    docker build -t tanbui/mongodb:3.0 .
# Create the container:
#    docker run -i -t --name mongodb3.0 -p 27017:27017 tanbui/mongodb:3.0


FROM       ubuntu:14.04

MAINTAINER Tan Bui <trungtanbui@gmail.com>

RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927

RUN echo "deb http://repo.mongodb.org/apt/ubuntu "$(lsb_release -sc)"/mongodb-org/3.2 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-3.2.list

RUN apt-get update && apt-get install -y mongodb-org

RUN mkdir -p /data/db

EXPOSE 27017

ENTRYPOINT ["/usr/bin/mongod"]
