drop table if exists vacancies;
create TABLE if not exists vacancies (
id bigint not null primary key AUTO_INCREMENT ,
title varchar(255) not null ,
salary integer not null,
experience varchar(255) not null ,
city varchar(255) not null
);