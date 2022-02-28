create database DanhSach
go
use  DanhSach
go
create table users
(
	ID int not null  primary key ,
	ten nvarchar(30) ,
	phone char(10) ,
	UserName varchar(20),
	Passwords varchar(10),
	roles char(10)
)
go
insert into users
	(ID,ten,phone,UserName,Passwords,roles)
VALUES
(1,N'Phan Đức Kiên','0192837393','PhanKien','123456','admin'),
( 2  ,N'Phan Đức Kiên','0192830393','PhanKien1','123456','use');

