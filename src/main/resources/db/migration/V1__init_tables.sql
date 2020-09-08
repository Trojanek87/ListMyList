drop table if exists tasks;

create table tasks
(
    id Long primary key auto_increment,
    content varchar(100) not null,
    done bit
);

drop table if exists comments;

create table comments
(
     id LONG primary key auto_increment,
     content varchar(100) not null

);

alter table comments add column task_id LONG;
alter table comments add foreign key (task_id) references tasks (id);

create table categories
(
    id LONG primary key auto_increment,
    name varchar(100) not null

);
create table lists
(
    id LONG primary key auto_increment,
    name varchar(100) not null

);
create table users
(
    id LONG primary key auto_increment,
    name varchar(100) not null

);
