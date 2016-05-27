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
  id                 BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title              VARCHAR(255),
  subtitle           VARCHAR(500),
  content            LONGTEXT,
  release_date       DATETIME        DEFAULT NULL,
  last_modified_date DATETIME        DEFAULT NULL,
  author_id          BIGINT,
  modifier_id        BIGINT
);

INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 1', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 2', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 3', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 4', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 5', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 6', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 7', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 8', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 9', 'Short summary Short summary Short summary', '', 1, 1);
INSERT INTO article (title, subtitle, content, author_id, modifier_id)
VALUES ('Test Article 10', 'Short summary Short summary Short summary', '', 1, 1);

CREATE TABLE category (
  id   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255)
);

INSERT INTO category (name) VALUES ('Default');

CREATE TABLE article_types (
  article_id  BIGINT UNSIGNED,
  category_id BIGINT UNSIGNED
);

INSERT INTO article_types (article_id, category_id) VALUES (1, 1);