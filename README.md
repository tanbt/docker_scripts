# Docker Script
Dockerfile and scripts for Web Environment

## Ubuntu base:
* Updated to 18.04LTS version
* Support custome timezone when running the container (see Dockerfile for example usage)

## Apache
* IMPORTANT: please set php timezone by yourself (using PHP CLI or enter the container to edit php.ini)
* Use Ubuntu 18.04 above
* Auto-start apache, mysql using supervisor
* Phpyadmin
* For simple usage, only document root folder is exposed to host machine (see Dockerfile for example usage)

