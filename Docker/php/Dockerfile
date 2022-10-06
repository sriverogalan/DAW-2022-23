FROM php:7.2-apache 
WORKDIR /var/www/html/ 

RUN docker-php-ext-install mysqli pdo pdo_mysql
RUN docker-php-ext-enable mysqli pdo pdo_mysql