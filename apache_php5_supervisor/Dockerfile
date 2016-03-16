# Tan Bui personal image, this image based on Ubuntu 14.04
# This image will be tagged with the name:
#    docker build -t tanbui/apache_ssl_php7:2.4.x .
#
# Create the container:
#    docker run -v /home/tanub/etc/apache2/sites-available:/data/config/apache2/sites-available:rw -v /home/tanub/www/iconic_intl:/data/www/iconic_intl:rw --name apache2.4 -p 80:80 -p 443:443 tanbui/apache_ssl_php7:14.04
#

FROM tanbui/ubuntu_base:14.04

MAINTAINER TAN BUI trungtanbui@gmail.com

ENV VOLUME_DATA /data
ENV VOLUME_CONFIG /data/config
ENV VOLUME_LOG /data/log

# Update APT and install supervisord
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install supervisor && \
    DEBIAN_FRONTEND=noninteractive apt-get -y clean

# Install apache 2.4
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install apache2 libapache2-mod-php5 libapache2-mod-xsendfile mysql-client telnet && \
    a2enmod rewrite && \
    a2enmod vhost_alias && \
    a2enmod xsendfile

RUN mkdir -p $VOLUME_CONFIG && \ 
    mkdir -p $VOLUME_DATA && \
    mkdir -p $VOLUME_LOG  && \
    mkdir -p $VOLUME_LOG/apache2  && \
    chmod 775 $VOLUME_LOG -R  && \

    mv /etc/apache2 /etc/apache2_origin && \
    ln -s /etc/apache2_origin $VOLUME_CONFIG/apache2 && \
    ln -s $VOLUME_CONFIG/apache2 /etc/apache2 && \

    mv /var/www /var/www_origin && \
    ln -s /var/www_origin $VOLUME_DATA/www && \
    ln -s $VOLUME_DATA/www /var/www && \
    chown www-data:www-data -h /var/www && \

    rm /var/log/apache2 -rf && \
    ln -s $VOLUME_LOG/apache2 /var/log/apache2 && \
    chown www-data:www-data -h /var/log/apache2 && \

    mv /etc/php5 /etc/php5_origin && \
    ln -s /etc/php5_origin $VOLUME_CONFIG/php5 && \
    ln -s $VOLUME_CONFIG/php5 /etc/php5 && \

    sed "s/^;date.timezone.*$/date.timezone=Asia\/Ho_Chi_Minh /g" -i /etc/php5/apache2/php.ini

# Add apache into supervisord config
RUN echo "\
[program:apache2]\n\
command=/bin/bash -c \"source /etc/apache2/envvars && exec /usr/sbin/apache2 -DFOREGROUND\"\n\
numprocs=1\n\
autostart=true\n\
autorestart=true\
" >> /etc/supervisor/conf.d/apache2.conf

# Update php5 to php7
RUN apt-get purge php5-common -y && apt-get autoremove -y

RUN DEBIAN_FRONTEND=noninteractive add-apt-repository ppa:ondrej/php -y && apt-get update -y

RUN DEBIAN_FRONTEND=noninteractive apt-get install -y php7.0 php7.0-common libapache2-mod-php7.0 php7.0-fpm php7.0-mysql php-memcached php7.0-cli php7.0-mbstring php7.0-mcrypt php7.0-xml php7.0-intl php7.0-json php-sqlite3 && sed "s/^;date.timezone.*$/date.timezone=Asia\/Ho_Chi_Minh /g" -i /etc/php/7.0/apache2/php.ini

RUN apt-get upgrade -y && apt-get autoremove -y

ADD run.sh /run.sh
RUN chmod +x /run.sh

EXPOSE 80
EXPOSE 443

CMD ["/run.sh"]
