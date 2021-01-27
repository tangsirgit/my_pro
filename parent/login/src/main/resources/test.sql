CREATE TABLE `log_tb` (
  `log_id` int(36) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `user_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名字',
  `user_ip` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户IP',
  `request_method` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '请求方法',
  `request_desc` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '方法描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='日志表';


INSERT INTO `project`.`log_tb`(`log_id`, `user_id`, `user_ip`, `request_method`, `request_desc`, `create_time`) VALUES (1, 'wangwu', '192.168.0.91', 'com.my.emplogin.controller.UserController.getUserSelfInfo', '获取个人信息', '2021-01-20 15:12:11');
INSERT INTO `project`.`log_tb`(`log_id`, `user_id`, `user_ip`, `request_method`, `request_desc`, `create_time`) VALUES (2, 'wangwu', '192.168.0.91', 'com.my.emplogin.controller.UserController.getUserSelfInfo', '获取个人信息', '2021-01-20 11:07:05');
INSERT INTO `project`.`log_tb`(`log_id`, `user_id`, `user_ip`, `request_method`, `request_desc`, `create_time`) VALUES (3, 'wangwu', '192.168.0.91', 'com.my.emplogin.controller.UserController.getUserSelfInfo', '获取个人信息', '2021-01-20 11:10:04');
INSERT INTO `project`.`log_tb`(`log_id`, `user_id`, `user_ip`, `request_method`, `request_desc`, `create_time`) VALUES (4, NULL, '192.168.0.91', 'com.my.emplogin.controller.UserController.login', '登录', '2021-01-20 15:14:30');
INSERT INTO `project`.`log_tb`(`log_id`, `user_id`, `user_ip`, `request_method`, `request_desc`, `create_time`) VALUES (5, NULL, '192.168.0.91', 'com.my.emplogin.controller.UserController.login', '登录', '2021-01-20 15:14:36');
INSERT INTO `project`.`log_tb`(`log_id`, `user_id`, `user_ip`, `request_method`, `request_desc`, `create_time`) VALUES (6, NULL, '192.168.0.91', 'com.my.emplogin.controller.UserController.login', '登录', '2021-01-20 15:25:43');
INSERT INTO `project`.`log_tb`(`log_id`, `user_id`, `user_ip`, `request_method`, `request_desc`, `create_time`) VALUES (7, NULL, '192.168.91.1', 'com.my.emplogin.controller.UserController.login', '登录', '2021-01-27 13:48:56');


CREATE TABLE `user_login_valid` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(50) COLLATE utf8_croatian_ci NOT NULL COMMENT '用户id/账号',
  `token` varchar(255) COLLATE utf8_croatian_ci NOT NULL COMMENT 'token',
  `fail_time` datetime NOT NULL COMMENT 'token失效时间',
  `create_date` datetime NOT NULL COMMENT '生成token时间',
  `status` tinyint(1) unsigned zerofill NOT NULL COMMENT 'token状态：0 效； 1 已失效',
  `ip` varchar(255) COLLATE utf8_croatian_ci NOT NULL COMMENT '登录id地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci COMMENT='登录验证token表';

INSERT INTO `project`.`user_login_valid`(`id`, `user_id`, `token`, `fail_time`, `create_date`, `status`, `ip`) VALUES (4, 'wangwu', '72ad96df-4d99-4f2d-9bdc-64209b9b0c17', '2021-01-20 17:18:00', '2021-01-13 17:18:00', 0, '0:0:0:0:0:0:0:1');
INSERT INTO `project`.`user_login_valid`(`id`, `user_id`, `token`, `fail_time`, `create_date`, `status`, `ip`) VALUES (5, 'wangwu', '154d488f-fc4f-43e4-b671-dedbf6d3cf73', '2021-01-21 14:20:43', '2021-01-14 14:20:43', 0, '0:0:0:0:0:0:0:1');
INSERT INTO `project`.`user_login_valid`(`id`, `user_id`, `token`, `fail_time`, `create_date`, `status`, `ip`) VALUES (6, 'wangwu', 'cfc7c990-25cd-494c-b804-ae79e975489d', '2021-01-23 14:28:49', '2021-01-14 14:28:49', 0, '127.0.0.1');
INSERT INTO `project`.`user_login_valid`(`id`, `user_id`, `token`, `fail_time`, `create_date`, `status`, `ip`) VALUES (7, 'wangwu', 'd19e2538-ac1c-40df-90cd-bf038143ab8f', '2021-01-27 15:25:43', '2021-01-20 15:25:43', 0, '192.168.0.91');
INSERT INTO `project`.`user_login_valid`(`id`, `user_id`, `token`, `fail_time`, `create_date`, `status`, `ip`) VALUES (8, 'wangwu', '8d53233c-bbc1-4307-986d-16de1f5975d6', '2021-02-03 13:48:56', '2021-01-27 13:48:56', 0, '192.168.91.1');


CREATE TABLE `user_tb` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(50) COLLATE utf8_croatian_ci NOT NULL COMMENT '用户id/账号',
  `user_name` varchar(255) COLLATE utf8_croatian_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(255) COLLATE utf8_croatian_ci NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(1) unsigned zerofill NOT NULL COMMENT '用户状态：0 正常状态 ；1 冻结状态',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci COMMENT='用户基本信息表';

INSERT INTO `project`.`user_tb`(`id`, `user_id`, `user_name`, `password`, `create_time`, `update_time`, `status`) VALUES (1, 'tanghuai', '唐槐', 'f23e9dfb059f66452e68770869e27b28', '2021-01-12 20:37:45', NULL, 0);
INSERT INTO `project`.`user_tb`(`id`, `user_id`, `user_name`, `password`, `create_time`, `update_time`, `status`) VALUES (2, 'zhangsan', '张三', 'e10adc3949ba59abbe56e057f20f883e', '2021-01-12 21:36:42', NULL, 0);
INSERT INTO `project`.`user_tb`(`id`, `user_id`, `user_name`, `password`, `create_time`, `update_time`, `status`) VALUES (3, 'lisi', '李四', 'FAAAFLG@DD@B@CBCEGDC', '2021-01-13 10:33:07', NULL, 0);
INSERT INTO `project`.`user_tb`(`id`, `user_id`, `user_name`, `password`, `create_time`, `update_time`, `status`) VALUES (5, 'wangwu', '王五', 'EFG@ABCL', '2021-01-13 10:44:17', NULL, 0);

