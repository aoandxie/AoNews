# Environment: mysql
drop database if exists aonews;
create database aonews default charset = utf8;
use aonews;

drop table if exists User;
drop table if exists Keyword;
drop table if exists News;
drop table if exists Interest;
drop table if exists History;

create table User(
	loginId char(20),
	pswd char(20),
	mail varchar(50),
	primary key(loginId)
);

create table Keyword(
	word char(10),
	primary key(word)
);

create table News(
	newsId char(10),
	title varchar(70),
	srcUrl varchar(100),
	srcTime varchar(30),
	word char(10) null,
	primary key(newsId),
	foreign key(word) references Keyword(word)
);

create table Interest(
	uid char(20),
	word char(10),
	primary key(uid,word),
	foreign key(uid) references User(loginId),
	foreign key(word) references Keyword(word)
);

create table History(
	uid char(20),
	nid char(10),
	uTime timestamp default current_timestamp,
	primary key(uid, nid, uTime),
	foreign key(uid) references User(loginId),
	foreign key(nid) references News(newsId)
);