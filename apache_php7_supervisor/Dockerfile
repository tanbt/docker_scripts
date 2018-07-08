# Tan Bui Apache PHP7 with Supervisor, based on Ubuntu 18.04
# This image will be tagged with the name:
#    docker build -t tanbui/apache_php7_supervisor:2.4 .
#
# Create the container:
#    docker run -v E:\www:/data/www:rw -v E:\www\apache\sites-enabled:/etc/apache2/sites-enabled:rw --name webserver -p 80:80 -e "TZ=Europe/Helsinki" tanbui/apache_php7_supervisor:2.4
#
# Check system time: `# date`
# Check php time:     `# php -r 'echo date("d/M/yy h:m:s");'`

FROM tanbui/ubuntu_base:18.04

LABEL maintainer="trungtanbui@gmail.com"

ENV VOLUME_DATA /data
ENV VOLUME_CONFIG /data/config

# Update APT and install supervisord
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install supervisor && \
    DEBIAN_FRONTEND=noninteractive apt-get -y clean

# Install apache 2.4
RUN DEBIAN_FRONTEND=noninteractive apt -y install apache2 mariadb-server mariadb-client && \
    a2enmod rewrite && a2enmod vhost_alias &&  echo "ServerName localhost" >> /etc/apache2/apache2.conf

# Orgazine root data folder
RUN mkdir -p $VOLUME_DATA && \
    mkdir -p $VOLUME_CONFIG && \
    chmod 775 $VOLUME_DATA -R && \

    mv /etc/apache2 /etc/apache2_origin && \
    ln -s /etc/apache2_origin $VOLUME_CONFIG/apache2 && \
    ln -s $VOLUME_CONFIG/apache2 /etc/apache2 && \

    mv /var/www /var/www_origin && \
    ln -s /var/www_origin $VOLUME_DATA/www && \
    ln -s $VOLUME_DATA/www /var/www

# Add apache into supervisord config
RUN echo "\
[program:apache2]\n\
command=/bin/bash -c \"source /etc/apache2/envvars && exec /usr/sbin/apache2 -DFOREGROUND\"\n\
numprocs=1\n\
autostart=true\n\
autorestart=true\
" >> /etc/supervisor/conf.d/apache2.conf

# Add mysql into supervisord config
RUN echo "\
[program:mysqld]\n\
command=mysqld_safe\n\
numprocs=1\n\
autostart=true\n\
autorestart=true\
" >> /etc/supervisor/conf.d/mysqld.conf

RUN DEBIAN_FRONTEND=noninteractive add-apt-repository ppa:ondrej/php -y && apt-get update -y
RUN apt install -y php7.2 libapache2-mod-php7.2

RUN DEBIAN_FRONTEND=noninteractive apt install -y php-memcached php7.2-common && \
    DEBIAN_FRONTEND=noninteractive apt install -y php7.2-fpm php7.2-curl php7.2-intl php7.1-mcrypt php7.2-xmlrpc && \
    DEBIAN_FRONTEND=noninteractive apt install -y php7.2-json php7.2-sqlite3 php7.2-mysql php7.2-opcache && \
    DEBIAN_FRONTEND=noninteractive apt install -y php-memcached php7.2-common

# sed "s/^;date.timezone.*$/date.timezone=$TZ /g" -i /etc/php/7.2/apache2/php.ini && \
RUN sed "s/^upload_max_filesize.*$/upload_max_filesize=128M /g" -i /etc/php/7.2/apache2/php.ini && \
    sed "s/^default_socket_timeout.*$/default_socket_timeout=180 /g" -i /etc/php/7.2/apache2/php.ini

COPY 000-default-tanbui.conf /etc/apache2/sites-enabled/000-default-tanbui.conf
COPY run.sh /run.sh
RUN chmod +x /run.sh

EXPOSE 80
EXPOSE 443

CMD ["/run.sh"]
