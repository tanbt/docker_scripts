# Docker Script
Dockerfile and scripts for Web Environment
**IMPORTANT**: Please read the Dockerfile header for examples, carefuly change parameters's values to your machine

## Ubuntu base:
* Updated to 18.04LTS version
* Support custome timezone when running the container (see Dockerfile for example usage)

## Apache
* IMPORTANT: please set php timezone by yourself (using PHP CLI or enter the container to edit php.ini)
* Use Ubuntu 18.04 above
* Auto-start apache, mysql using supervisor
* You can expose web root document and apache site-enabled to your host machine, but default virtualhost file won't work.
You will need to copy a virtualhost file to site-enabled. E.g. you can use my file `000-default-tanbui.conf` in git repo