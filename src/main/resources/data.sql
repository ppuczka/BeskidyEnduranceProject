-- insert into user (username, password, enabled) VALUES ("user", "pass", true);
-- insert into role (role) VALUES ("ADMIN");

REPLACE INTO `role` VALUES (1,'ADMIN');
REPLACE INTO `role` VALUES (2,'USER');

INSERT INTO `user` (`user_id`, `active`, `created`, `email`, `first_name`, `last_name`, `password`, `points`)
VALUES (1, 1, '2018-12-02 11:11:04', 'p.puczka@gmail.com', 'Przemek', 'Puczka', '$2a$10$f4oILZUHHr2hNrE/FZFpzOPcNrs5IZ8vishpl8Ep35SdD/x2i63RC', 0);
