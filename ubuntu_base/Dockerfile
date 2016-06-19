# Anphabe Docker Base Image, this image based on Ubuntu 14.04
# This image will be tagged with the name: anphabe/base:14.04
# - docker build -t tanbui/ubuntu_base:14.04 .
#
# Create the container:
# - docker run -t -i --name xxx tanbui/ubuntu_base:14.04 /bin/bash
#

FROM ubuntu:14.04

MAINTAINER TAN BUI trungtanbui@gmail.com

# fix user environment
RUN echo "alias ll='ls -alh'" >> /etc/bash.bashrc && \
    mv /etc/localtime /etc/localtime.bk && \
    ln -s /usr/share/zoneinfo/Asia/Ho_Chi_Minh /etc/localtime

RUN apt-get update

RUN apt-get install -y locales language-pack-en-base

ENV LC_ALL en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LC_CTYPE en_US.UTF-8

# Update APT    
RUN locale-gen en_US.UTF-8 && \
    DEBIAN_FRONTEND=noninteractive  apt-get update -y && \
    DEBIAN_FRONTEND=noninteractive  apt-get upgrade -y && \
    DEBIAN_FRONTEND=noninteractive  apt-get -y install software-properties-common python-software-properties vim wget curl
