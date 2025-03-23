CREATE DATABASE IF NOT EXISTS healthyLife;
USE healthyLife;

CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(50),
    age INT,
    gender VARCHAR(10),
    activity_level VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS exercise_log (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            exercised BOOLEAN,
                                            logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS water_log (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         water_intake VARCHAR(50),
    logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS fruit_log (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         fruit_name VARCHAR(50),
    logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS vegetable_log (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             vegetable_name VARCHAR(50),
    logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
SELECT * FROM users;
SELECT * FROM fruit_log;
SELECT * FROM vegetable_log;
SELECT * FROM water_log;
SELECT * FROM exercise_log;
TRUNCATE TABLE users;
TRUNCATE TABLE exercise_log;
TRUNCATE TABLE water_log;
TRUNCATE TABLE fruit_log;
TRUNCATE TABLE vegetable_log;