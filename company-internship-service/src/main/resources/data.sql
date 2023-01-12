INSERT INTO users (username, password, enabled) values
 ('user','{bcrypt}$2a$10$1hd5QwmO6scy0Ig4rrtUf.swQLsE/icC7OnePhU9WKY2NHYRnwl1y', true);
INSERT INTO users (username, password, enabled) values
 ('admin','{bcrypt}$2a$10$If.eZDWFF5ARkLDLS7UIyu6CBRAEqIbBVD8FwOYuFUp8Fgt50MTw2', true);

INSERT INTO authorities (username, authority) values ('user','ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin','ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin','ROLE_ADMIN');