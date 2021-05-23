DROP SCHEMA IF EXISTS `people`;
CREATE SCHEMA IF NOT EXISTS `people` DEFAULT CHARACTER SET utf8;
use people;
drop table if exists person;
drop table if exists address;

create table if not exists address
(
  id     int auto_increment
    primary key,
  street varchar(50) null,
  house  int         null
);

create table if not exists person
(
  id         int auto_increment
    primary key,
  name       varchar(50) null,
  sur_name   varchar(50) null,
  age        int         null,
  address_id int         not null,
  constraint fk_person_address
    foreign key (address_id) references address (id)
      on update cascade on delete cascade
);