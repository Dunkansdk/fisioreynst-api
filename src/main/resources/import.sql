INSERT INTO tbl_roles(name) VALUES('ROLE_USER');
INSERT INTO tbl_roles(name) VALUES('ROLE_ADMIN');
INSERT INTO tbl_users(id, email, password, username) VALUES (1, 'emanueldurso1@gmail.com', '$2a$10$8t9EBVzCBPziWWXQkBvXxeDlqXqVy2LFEIEZ5gxTxel1s8.X.l0Zy', 'dunkan') ON CONFLICT (id) DO NOTHING;
INSERT INTO tbl_users(id, email, password, username) VALUES (2, 'martinarava@gmail.com', '$2a$10$8t9EBVzCBPziWWXQkBvXxeDlqXqVy2LFEIEZ5gxTxel1s8.X.l0Zy', 'martu') ON CONFLICT (id) DO NOTHING;
ALTER SEQUENCE tbl_users_id_seq RESTART WITH 3;
INSERT INTO tbl_user_roles (user_id, role_id) VALUES (1,2);
INSERT INTO tbl_user_roles (user_id, role_id) VALUES (2,1);