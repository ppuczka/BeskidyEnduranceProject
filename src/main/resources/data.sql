-- insert into user (username, password, enabled) VALUES ("user", "pass", true);
-- insert into role (role) VALUES ("ADMIN");
REPLACE INTO `role` VALUES (1,'ADMIN');
REPLACE INTO `user` (first_name, last_name, password, email) VALUES ("adminName","adminLastName", "admin", "admin@admin.pl");
-- REPLACE INTO `user_role` VALUES (1, 1);

INSERT INTO `user_role` (`user_id`, `role_id`)VALUES (1, 1);

INSERT INTO `user` (`user_id`, `active`, `email`, `first_name`, `last_name`, `password`, `points`)
VALUES
	(1, 0, 'admin@admin.pl', 'Admin', 'AdminLastName', 'admin', 0);

