DROP DATABASE IF EXISTS userdb;
CREATE DATABASE userdb
CHARACTER SET 'UTF8'
;

USE userdb;

GRANT ALL PRIVILEGES ON userdb.* TO 'root';

CREATE TABLE users (
  user_id     INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  user_name   VARCHAR(64),
  user_pwd    VARCHAR(512)

) 
  ENGINE InnoDB
;

CREATE TABLE groups (
  group_id     INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  group_name   VARCHAR(64)
) 
  ENGINE InnoDB
;


CREATE TABLE users2groups (
  user2group_id         INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  user2group_user_id    INTEGER UNSIGNED NOT NULL
                        REFERENCES users(user_id)
                        MATCH FULL
                        ON DELETE CASCADE,
  user2group_group_id   INTEGER UNSIGNED NOT NULL
                        REFERENCES groups(group_id)
                        MATCH FULL
                        ON DELETE CASCADE
) 
  ENGINE InnoDB
;

CREATE VIEW v_users_to_groups AS 
SELECT user_name, group_name
  FROM users
  JOIN users2groups ON user2group_user_id = user_id
  JOIN groups ON user2group_group_id = group_id
;


INSERT INTO users (user_name, user_pwd) VALUES ('user', SHA2('test', 256));
INSERT INTO users (user_name, user_pwd) VALUES ('admin', SHA2('sicher', 256));
UPDATE users SET user_pwd = MD5('test') WHERE user_name = 'admin';
UPDATE users SET user_pwd = SHA2('test',256) WHERE user_name = 'admin';

INSERT INTO groups (group_name) VALUES ('admins');
INSERT INTO groups (group_name) VALUES ('users');

INSERT INTO users2groups (user2group_user_id, user2group_group_id) VALUES (1,2);
INSERT INTO users2groups (user2group_user_id, user2group_group_id) VALUES (2,1);

SELECT * FROM users;
SELECT * FROM groups;
SELECT * FROM users2groups;
SELECT * FROM v_users_to_groups;

SELECT user_pwd FROM users WHERE user_name = 'admin'


