CREATE SCHEMA IF NOT EXISTS java301;
USE java301 ;

CREATE TABLE IF NOT EXISTS java301.users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  email VARCHAR(128) NULL,
  phone_number VARCHAR(10) NULL,
  active tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS java301.user_images (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  content_type VARCHAR(45) NOT NULL,
  image BLOB NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS java301.user_roles (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS java301.user_properties (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  prop_name VARCHAR(45) NOT NULL,
  prop_value VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));
  
    CREATE TABLE IF NOT EXISTS java301.products(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  qty INT, 
  price VARCHAR(10) NOT NULL,
  PRIMARY KEY (id));

  CREATE TABLE IF NOT EXISTS java301.product_images(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  _id INT UNSIGNED NOT NULL,
  content_type VARCHAR(45) NOT NULL,
  image BLOB NOT NULL,
  PRIMARY KEY (id));
  
      CREATE TABLE IF NOT EXISTS java301.smoothies(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  ing VARCHAR (150) NOT NULL, 
  price VARCHAR(10) NOT NULL,
  PRIMARY KEY (id));

  CREATE TABLE IF NOT EXISTS java301.smoothie_images(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  _id INT UNSIGNED NOT NULL,
  content_type VARCHAR(45) NOT NULL,
  image BLOB NOT NULL,
  PRIMARY KEY (id));
