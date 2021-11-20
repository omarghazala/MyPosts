create table posts(
id bigint(20) auto_increment,
content MEDIUMTEXT NOT NULL,
status varchar(10),
created_at DATETIME default Now(),
post_creator_id bigint(20) NOT NULL,
primary key(id)
);

ALTER TABLE posts
ADD CONSTRAINT postsConstraint
FOREIGN KEY (post_creator_id) REFERENCES users(id);