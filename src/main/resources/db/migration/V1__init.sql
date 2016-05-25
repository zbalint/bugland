CREATE TABLE user (
  id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(64),
  last_name  VARCHAR(64),
  nick_name  VARCHAR(32)     DEFAULT NULL,
  email      VARCHAR(255),
  company    VARCHAR(64)     DEFAULT NULL,
  password   VARCHAR(1024)
);

INSERT INTO user (first_name, last_name, email, password) VALUES ('Super', 'User', 'super@user.com', '12345');
INSERT INTO user (first_name, last_name, email, password) VALUES ('Normal', 'User', 'normal@user.com', '12345');

CREATE TABLE user_group (
  id   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE user_roles (
  user_id  BIGINT UNSIGNED,
  group_id BIGINT UNSIGNED
);

INSERT INTO user_group (name) VALUES ('Admin');
INSERT INTO user_group (name) VALUES ('User');
INSERT INTO user_roles (user_id, group_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, group_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, group_id) VALUES (2, 2);

CREATE TABLE article (
  name               VARCHAR(255),
  content            LONGTEXT,
  release_date       DATETIME,
  last_modified_date DATETIME,
  author_id          BIGINT,
  modifier_id        BIGINT
);

CREATE TABLE category (
  id   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE articles (
  article_id  BIGINT UNSIGNED,
  category_id BIGINT UNSIGNED
);