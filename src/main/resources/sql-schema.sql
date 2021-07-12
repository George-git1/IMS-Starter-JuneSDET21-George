drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id`));




CREATE TABLE IF NOT EXISTS `ims`.`items` (
  `item_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`item_id`));




CREATE TABLE IF NOT EXISTS `ims`.`orders` (
  `orders_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`orders_id`),
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `ims`.`customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);




CREATE TABLE IF NOT EXISTS `ims`.`orders_items` (
  `orders_items_id` INT NOT NULL AUTO_INCREMENT,
  `orders_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`orders_items_id`),
  CONSTRAINT `orders_id`
    FOREIGN KEY (`orders_id`)
    REFERENCES `ims`.`orders` (`orders_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `item_id`
    FOREIGN KEY (`item_id`)
    REFERENCES `ims`.`items` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

