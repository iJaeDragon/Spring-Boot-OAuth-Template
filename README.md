<<<<<<< HEAD
# 10장. OAuth2로 로그인/로그아웃 구현하기
# Q&A 
=======
# Spring-Boot-OAuth-Template
 Spring-Boot-OAuth-Template

### DB Script

```
drop table jd.users;
create table users (
    id int(10) primary key,
    email VARCHAR(500) ,
    nickname VARCHAR(500),
    password VARCHAR(500)
);
alter table users modify column id int NOT NULL AUTO_INCREMENT;
SELECT * FROM jd.users;


drop table refresh_token;
create table refresh_token (
    id int(10) primary key,
    refresh_token VARCHAR(500),
    user_id VARCHAR(500)
);
alter table refresh_token modify column id int NOT NULL AUTO_INCREMENT;
ALTER TABLE refresh_token CONVERT TO CHARSET utf8;
select * from refresh_token;
```
>>>>>>> 66e554abb40de954dff71021c691970337feed8a
