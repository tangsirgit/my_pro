drop table if exists tb_user_role;

drop table if exists tb_role_res;

drop table if exists tb_user;

drop table if exists tb_role;

drop table if exists tb_resource;

create table tb_user(
  id integer not null auto_increment,
  username varchar(32) not null unique,
  password varchar(63) not null,
  primary key(id)
);

insert into tb_user(username, password) values('admin', '$2a$10$4wP9KGFF0DGlPr.NSmC7buMa/hWuQ8ADGjN.YBkA7N043GHCgNRN.');
insert into tb_user(username, password) values('guest', '$2a$10$0PqU.EFfKTwuBRJFP9TUMOo.58b0oujtj8O6oj43SPt7KMvDP1tb.');
insert into tb_user(username, password) values('bjsxt', '$2a$10$j2Tz.fUjtCGXEkSXiz26fupes5HUEH..0P/m3LLzqaSn8EQ43nuPO');

create table tb_role(
  id integer not null auto_increment,
  role_name varchar(32),
  primary key (id)
);

insert into tb_role(role_name) values('管理员');
insert into tb_role(role_name) values('访客');

create table tb_resource(
  id integer not null auto_increment,
  res_name varchar(32) comment '权限名称',
  res varchar(32) comment '权限描述符号， 如： admin:query  admin:create',
  primary key(id)
);

insert into tb_resource(res_name, res) values('管理员查询权限','admin:read');
insert into tb_resource(res_name, res) values('管理员写权限','admin:write');
insert into tb_resource(res_name, res) values('访客查询权限','guest:read');
insert into tb_resource(res_name, res) values('访客写权限','guest:write');
insert into tb_resource(res_name, res) values('登录权限','all:login');
insert into tb_resource(res_name, res) values('登出权限','all:logout');
insert into tb_resource(res_name, res) values('错误逻辑显示权限','all:error');
insert into tb_resource(res_name, res) values('入口页面显示权限','all:toMain');

create table tb_user_role(
  user_id integer not null,
  role_id integer not null,
  primary key (user_id, role_id)
);

insert into tb_user_role(user_id, role_id) values(1, 1);
insert into tb_user_role(user_id, role_id) values(2, 2);
insert into tb_user_role(user_id, role_id) values(3, 1);

create table tb_role_res(
  role_id integer not null,
  res_id integer not null,
  primary key(role_id, res_id)
);

insert into tb_role_res(role_id, res_id) values(1, 1);
insert into tb_role_res(role_id, res_id) values(1, 2);
insert into tb_role_res(role_id, res_id) values(2, 3);
insert into tb_role_res(role_id, res_id) values(2, 4);
insert into tb_role_res(role_id, res_id) values(1, 5);
insert into tb_role_res(role_id, res_id) values(1, 6);
insert into tb_role_res(role_id, res_id) values(1, 7);
insert into tb_role_res(role_id, res_id) values(1, 8);
insert into tb_role_res(role_id, res_id) values(2, 5);
insert into tb_role_res(role_id, res_id) values(2, 6);
insert into tb_role_res(role_id, res_id) values(2, 7);
insert into tb_role_res(role_id, res_id) values(2, 8);