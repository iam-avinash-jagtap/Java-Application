# Techaj Inquiry Form Project

This project is a simple Java-based web application that allows users to submit inquiries for tech products.

## Folders
- src/: Java source files
- lib/: External libraries (like MySQL connector)
- WebContent/: HTML and web-related files\

## Create Docker Image using Dockerfile
```bash
docker build -t java-app .
```
### Check Docker image
```bash
docker images
```
## Run contianer using Docker-compose.yml file
```bash
docker-compose up -d
```
### Check Running contiaer
```bash
docker ps
```

## Enter to Database Contianer
```bash
docker exec -it <Contianer_id> /bin/bash mysql -u root -p
```
### Password is - root
_FOllow more commands to go database_

```bash
SHOW databases;
```
---
```bash
CREATE DATABASE techaj_db;
```
---
```bash
USE techaj_db;
```
## Database Creation Steps 
```bash
CREATE DATABASE techaj_db;
USE techaj_db;

-- Create tables
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE brands (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT,
    brand_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE inquiries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    budget VARCHAR(50) NOT NULL,
    contact VARCHAR(50) NOT NULL,
    location VARCHAR(100) NOT NULL,
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

```
## See Database Entries 
```bash
SELECT * FROM users;
```