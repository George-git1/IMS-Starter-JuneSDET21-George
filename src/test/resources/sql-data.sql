INSERT INTO `imstest`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `imstest`.`items` (`name`, `price`) VALUES ('Ernie ball Strings', '5.4');
INSERT INTO `imstest`.`items` (`name`, `price`) VALUES ('Adapter', '3.50');
INSERT INTO `imstest`.`items` (`name`, `price`) VALUES ('Sausage', '4.00');
INSERT INTO `imstest`.`items` (`name`, `price`) VALUES ('EMG humbuckers', '145.23');
INSERT INTO `imstest`.`orders`(`customer_id`) VALUES (1);
INSERT INTO `imstest`.`orders_items`(`orders_id`, `item_id`) VALUES (1,1);