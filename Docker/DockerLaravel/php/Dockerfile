FROM php:8.2-apache-bullseye
WORKDIR /var/www/html/  
RUN apt update  
RUN apt install -y curl
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Install git
RUN apt install -y git

# Install Laravel
RUN composer global require laravel/installer 

