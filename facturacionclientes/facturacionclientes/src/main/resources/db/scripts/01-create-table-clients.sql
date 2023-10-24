create table clients (
name varchar (50) not null,
birthdate date,
dni char(9) primary key,
country varchar(50) not null,
premium boolean not null
);