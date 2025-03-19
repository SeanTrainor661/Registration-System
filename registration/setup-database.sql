-- Create the database
CREATE DATABASE IF NOT EXISTS aeroparker;

-- Use the database
USE aeroparker;

-- Create the customers table
CREATE TABLE IF NOT EXISTS customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    registered TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    email_address VARCHAR(255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address_line_1 VARCHAR(255) NOT NULL,
    address_line_2 VARCHAR(255),
    city VARCHAR(255),
    postcode VARCHAR(10) NOT NULL,
    phone_number VARCHAR(20)
);
