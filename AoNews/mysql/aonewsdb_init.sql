# Environment: mysql
# create schema
create database aonews;

# Login Info
# UserName less than 20 characters
# Password less than 20 characters
create table Login(
	UserName char(20),
	Password char(20) not null,
	Email char(20) not null,
	primary key(UserName)
)default charset = utf8;

# Keyword Info
# Word less than 10 characters
# HotIndex >= && HotIndex <= 255
create table Keyword(
	Word char(10),
	HotIndex tinyint unsigned not null,
	primary key(Word)
)default charset = utf8;

# News Info
# Local url: news/ + UrlID + .html
# Title less than 30 characters
# Source web site e.g. 163, tencent
# Publish time( yyyy-mm-dd hh:mm:ss )
create table News(
	UrlID char(10),
	Title varchar(30) not null,
	SrcWebsite varchar(50) not null,
	PublishTime varchar(30) not null,
	primary key(UrlID)
)default charset = utf8;

# User read keyword history
create table UserKeyword(
	UserName char(20),
	Word char(10),
	primary key(UserName,Word),
	foreign key(UserName) references Login(UserName),
	foreign key(Word) references Keyword(Word)
)default charset = utf8;

# News write keyword record
create table NewsKeyword(
	UrlID char(10),
	Word char(10),
	primary key(UrlID,Word),
	foreign key(UrlID) references News(UrlID),
	foreign key(Word) references Keyword(Word)
)default charset = utf8;