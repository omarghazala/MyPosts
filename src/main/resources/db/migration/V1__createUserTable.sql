create table users(
	id bigint(20) auto_increment,
	user_name varchar(400) unique,
	user_password varchar(400),
	full_name varchar(400),
	created_at DATETIME default Now(),
    primary key(id)
);