# client table
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information TEXT,
  autoapprove VARCHAR (255) default 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# user table
create table `user`(
  id BIGINT unsigned not null primary key auto_increment COMMENT '主键',
  username varchar(255) not null unique,
  `password` varchar(255),
  `e_mail` varchar(255),
  account_non_expired tinyint unsigned default '1',
  account_non_locked tinyint unsigned default '1',
  credentials_non_expired tinyint unsigned default '1',
  enabled tinyint unsigned default '1'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# role table
create table `oauth_role`(
  id BIGINT unsigned not null primary key auto_increment COMMENT '主键',
  `role` varchar(255) not null unique,
  description varchar(255) COMMENT '描述'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# authorties table
create table `oauth_authorities`(
  id BIGINT unsigned not null primary key auto_increment COMMENT '主键',
  `authority` varchar(255) not null unique,
  description varchar(255) COMMENT '描述'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# user role table
create table `oauth_user_role`(
  id BIGINT unsigned not null primary key auto_increment COMMENT '主键',
  `username` varchar(255) not null,
  `role` varchar(255) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# role authorities table
create table `oauth_role_auth`(
  id BIGINT unsigned not null primary key auto_increment COMMENT '主键',
  `role` varchar(255) not null,
  `authority` varchar(255) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
