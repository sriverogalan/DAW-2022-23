FROM php:8.2-apache-bullseye
WORKDIR /var/www/html/  
RUN apt update  
RUN apt install -y curl
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Install & run the MySQL Client
RUN docker-php-ext-install mysqli pdo pdo_mysql
RUN docker-php-ext-enable mysqli pdo pdo_mysql


# Install git
RUN apt install -y git 
RUN composer global require laravel/installer 