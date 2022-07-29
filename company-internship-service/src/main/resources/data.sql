INSERT INTO users (username, password, enabled) values
 ('user','{bcrypt}$2a$10$1hd5QwmO6scy0Ig4rrtUf.swQLsE/icC7OnePhU9WKY2NHYRnwl1y', true);
INSERT INTO users (username, password, enabled) values
 ('admin','{bcrypt}$2a$10$R2Pt5cezbO1b7wMAMT5FIuRBAeJtmdmjT2/hbMQqo23i8/Eyha3Zm', true);

INSERT INTO authorities (username, authority) values ('user','ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin','ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin','ROLE_ADMIN');