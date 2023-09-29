DROP TABLE IF EXISTS `users` CASCADE;
CREATE TABLE `users` (
    `userid` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(255) NOT NULL,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `user_name` VARCHAR(255) NOT NULL,
    UNIQUE (`email`)
);