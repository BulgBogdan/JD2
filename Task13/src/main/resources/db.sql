drop table if exists people.seller;
drop table if exists people.shop;

create table if not exists people.shop
(
  id           int auto_increment primary key,
  name         varchar(50)  not null,
  address      varchar(100) not null,
  created_date timestamp    not null,
  profit       int          not null
);

create table if not exists people.seller
(
  id         int auto_increment primary key,
  first_name varchar(30) not null,
  last_name  varchar(30) not null,
  salary     int         not null,
  shop_id    int,
  constraint fk_seller_shop
    foreign key (shop_id) references people.shop (id)
      on update cascade on delete cascade
);