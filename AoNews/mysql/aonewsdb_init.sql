# Environment: mysql
# create schema
create database aonews default charset = utf8;
use aonews;

# Login Info
# UserName less than 20 characters
# Password less than 20 characters
create table Login(
	UserName char(20),
	Password char(20),
	Mail varchar(50),
	primary key(UserName)
)

# Keyword Info
# Word less than 10 characters
# HotIndex >= && HotIndex <= 255
create table Keyword(
	Word char(10),
	HotIndex int unsigned,
	primary key(Word)
)

# News Info
# Local url: news/ + NewsID + .html
# Title less than 30 characters
# Source web site e.g. 163, tencent
# Publish time( yyyy-mm-dd hh:mm:ss )
create table News(
	NewsID char(10),
	Title varchar(70),
	SrcWebsite varchar(100),
	PublishTime varchar(30),
	primary key(NewsID)
)

# User read keyword history
create table UserKeyword(
	UserName char(20),
	Word char(10),
	primary key(UserName,Word),
	foreign key(UserName) references Login(UserName),
	foreign key(Word) references Keyword(Word)
)

# News write keyword record
create table NewsKeyword(
	NewsID char(10),
	Word char(10),
	primary key(NewsID,Word),
	foreign key(NewsID) references News(NewsID),
	foreign key(Word) references Keyword(Word)
)

# User read News record
create table UserNews(
	UserName char(20),
	NewsID char(10),
	CallTime timestamp default current_timestamp,
	primary key(UserName, NewsID),
	foreign key(UserName) references Login(UserName),
	foreign key(NewsID) references News(NewsID)
)