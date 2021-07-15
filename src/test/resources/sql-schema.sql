DROP SCHEMA IF EXISTS imstest;

CREATE SCHEMA IF NOT EXISTS imstest;

USE imstest;



CREATE TABLE IF NOT EXISTS `imstest`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));




CREATE TABLE IF NOT EXISTS `imstest`.`items` (
  `item_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`item_id`));




CREATE TABLE IF NOT EXISTS `imstest`.`orders` (
  `orders_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`orders_id`),
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `imstest`.`customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);




CREATE TABLE IF NOT EXISTS `imstest`.`orders_items` (
  `orders_items_id` INT NOT NULL AUTO_INCREMENT,
  `orders_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`orders_items_id`),
  CONSTRAINT `orders_id`
    FOREIGN KEY (`orders_id`)
    REFERENCES `imstest`.`orders` (`orders_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `item_id`
  
    FOREIGN KEY (`item_id`)
    REFERENCES `imstest`.`items` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
