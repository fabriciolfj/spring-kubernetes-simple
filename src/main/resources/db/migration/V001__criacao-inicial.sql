create table product(
id bigint not null auto_increment,
name varchar(100) not null,
primary key (id)
);

create table usuario(
id bigint not null auto_increment,
name varchar(100) not null,
password varchar(1000) not null,
primary key (id)
);