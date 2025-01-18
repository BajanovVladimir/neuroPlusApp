
insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_USER');

insert into users (login, password) values ('admin', '$2a$10$5WeirxeDfjq8O6lp1lLiCuw13AVQ5fMVatoErYait.lK.qI0Bl49u');
insert into users_roles (user_id,role_id) values(1,1);
insert into persons (user_id,name) values ('1','Administrator');