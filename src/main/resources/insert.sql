INSERT INTO authority (NAME) VALUES ('ROLE_USER');
INSERT INTO authority (NAME) VALUES ('ROLE_ADMIN');
INSERT INTO user (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, PHONENUMBER, ADDRESS, SECURITYNUMBER) VALUES ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, '6981825873', 'Athens','1234567890');
INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (1, 2);