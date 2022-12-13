FROM php:8-apache-bullseye
WORKDIR /var/www/html/ 

RUN docker-php-ext-install mysqli pdo pdo_mysql
RUN docker-php-ext-enable mysqli pdo pdo_mysql

RUN /bin/bash 
RUN cd /etc/apache2/mods-available/ 
RUN a2enmod rewrite.load request.load
