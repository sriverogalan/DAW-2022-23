FROM php:7.4.30-apache-bullseye
WORKDIR /var/www/html/ 
COPY prova.html var/www/html/

RUN docker-php-ext-install mysqli pdo pdo_mysql
RUN docker-php-ext-enable mysqli pdo pdo_mysql