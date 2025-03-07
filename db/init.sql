CREATE DATABASE cms_springboot;

use cms_springboot;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(255),
);

CREATE TABLE IF NOT EXISTS main_menu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    main_menu_name VARCHAR(255) NOT NULL,
    main_menu_desc TEXT NOT NULL,
    main_menu_redirect VARCHAR(255),
    main_menu_status BOOLEAN,
);

CREATE TABLE IF NOT EXISTS sub_menu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sub_menu_name VARCHAR(255) NOT NULL,
    sub_menu_desc TEXT NOT NULL,
    sub_menu_status BOOLEAN,
    main_menu_id INT NULL,
    FOREIGN KEY (main_menu_id) REFERENCES main_menu(id) ON DELETE NO ACTION
);