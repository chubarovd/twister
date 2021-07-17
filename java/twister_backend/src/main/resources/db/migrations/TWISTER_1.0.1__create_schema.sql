-----------
-- USERS --
-----------
CREATE TABLE users (
  user_id  INT8,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id)
);

------------
-- TWISTS --
------------
CREATE TABLE twists (
  twst_id      INT8,
  text         VARCHAR(4000) NOT NULL,
  author_id    INT8          NOT NULL,
  created_date TIMESTAMP     NOT NULL,
  PRIMARY KEY (twst_id),
  FOREIGN KEY (author_id) REFERENCES users (user_id)
);