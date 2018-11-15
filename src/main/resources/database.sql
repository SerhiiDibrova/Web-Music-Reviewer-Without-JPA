-- Table: User
CREATE TABLE customuser (
  id             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_firstname VARCHAR(255) NOT NULL,
  user_lastname  VARCHAR(255) NOT NULL,
  user_login     VARCHAR(255) NOT NULL,
  user_password  VARCHAR(255) NOT NULL,
  user_email     VARCHAR(255) NOT NULL,
  user_role      VARCHAR(255)
)
  ENGINE = InnoDB;

-- Table: User Role
CREATE TABLE role (
  id        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table: Artist
CREATE TABLE artist (
  id                INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  artist_firstname  VARCHAR(255) NOT NULL,
  artist_secondname VARCHAR(255) NOT NULL,
  artist_nickname   VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: Label
CREATE TABLE recordlabel (
  id            INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  label_name    VARCHAR(255) NOT NULL,
  label_country VARCHAR(255)
)
  ENGINE = InnoDB;

-- Table: Music Release
CREATE TABLE musicrelease (
  id             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  release_title  VARCHAR(255) NOT NULL,
  release_date   DATE         NOT NULL,
  recordlabel_id INT          NOT NULL,

  FOREIGN KEY (recordlabel_id) REFERENCES recordlabel (id)
)
  ENGINE = InnoDB;

-- Table: Review
CREATE TABLE review (
  id              INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  review_name     VARCHAR(255) NOT NULL,
  review_text     VARCHAR(255) NOT NULL,
  review_rate     INT          NOT NULL,
  review_time     DATE,
  musicrelease_id INT          NOT NULL,

  FOREIGN KEY (musicrelease_id) REFERENCES musicrelease (id)
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES customuser (id),
  FOREIGN KEY (role_id) REFERENCES role (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Table for mapping artist and label: artist_recordlabel
CREATE TABLE artist_recordlabel (
  artist_id INT NOT NULL,
  label_id  INT NOT NULL,

  FOREIGN KEY (artist_id) REFERENCES artist (id),
  FOREIGN KEY (label_id) REFERENCES recordlabel (id),

  UNIQUE (artist_id, label_id)
)
  ENGINE = InnoDB;

-- Table for mapping artist and label: artist_recordlabel
CREATE TABLE artist_musicrelease (
  artist_id       INT NOT NULL,
  musicrelease_id INT NOT NULL,

  FOREIGN KEY (artist_id) REFERENCES artist (id),
  FOREIGN KEY (musicrelease_id) REFERENCES musicrelease (id),

  UNIQUE (artist_id, musicrelease_id)
)
  ENGINE = InnoDB;

-- Table for mapping artist and label: artist_recordlabel
CREATE TABLE label_musicrelease (
  recordlabel_id  INT NOT NULL,
  musicrelease_id INT NOT NULL,

  FOREIGN KEY (recordlabel_id) REFERENCES recordlabel (id),
  FOREIGN KEY (musicrelease_id) REFERENCES musicrelease (id),

  UNIQUE (recordlabel_id, musicrelease_id)
)
  ENGINE = InnoDB;

-- Data Insert to table: user
INSERT INTO customuser VALUE (1, 'Sergii', 'Gagauz', 'Gagauz25', 'admin', 'gsa@gmail.com', 'admin');
INSERT INTO customuser VALUE (2, 'Mixim', 'Reality', 'Maxim15', 'admin', 'mrv@gmail.com', 'reviewer');

-- Data Insert to table: role
INSERT INTO role VALUE (1, 'admin');
INSERT INTO role VALUE (2, 'regular');
INSERT INTO role VALUE (3, 'reviewer');

-- Data Insert to table: Artist
INSERT INTO artist VALUE (1, 'Markus', 'Schulz', 'Markus Schulz');
INSERT INTO artist VALUE (2, 'Armin', 'van Buuren', 'Armin van Buuren');
INSERT INTO artist VALUE (3, 'Sander', 'van Doorn', 'Sander van Doorn');

-- Data Insert to table: Record_Label
INSERT INTO recordlabel VALUE (1, 'Colharbour Recordings', 'USA');
INSERT INTO recordlabel VALUE (2, 'Armada Recordings', 'Netherlands');
INSERT INTO recordlabel VALUE (3, 'Doorn Records', 'Netherlands');

-- Data Insert to table: Music Release
INSERT INTO musicrelease VALUE (1, 'Makus Schulz - Coldharbour (Original mix)', '2017-10-29', 1);
INSERT INTO musicrelease VALUE (2, 'Armin van Buuren - From the Dark (Original mix)', '2017-10-29', 2);

-- Data Insert to table: Review
INSERT INTO review VALUE (1, 'Review on Makus Schulz - Coldharbour', 'some text review', 10, '2017-10-30', 1);

-- Data Insert to table: User_roles
INSERT INTO user_roles VALUE (1, 1);
INSERT INTO user_roles VALUE (2, 2);

-- Data Insert to table: Artist_Recordlabel
INSERT INTO artist_recordlabel VALUE (1, 1);
INSERT INTO artist_recordlabel VALUE (2, 2);

-- Data Insert into table: Artist_Musicrelease
INSERT INTO artist_musicrelease VALUE (1, 1);
INSERT INTO artist_musicrelease VALUE (2, 2);

-- Data Insert into table: Label_Musicrelease
INSERT INTO label_musicrelease VALUE (1, 1);
INSERT INTO label_musicrelease VALUE (2, 2);

