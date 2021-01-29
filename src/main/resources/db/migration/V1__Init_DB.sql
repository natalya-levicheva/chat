create sequence hibernate_sequence start 1 increment 1;

create table addressee
(
    addressee_id int8 not null,
    is_read boolean not null,
    to_user_id int8,
    primary key (addressee_id)
);

create table message
(
    message_id   int8    not null,
    date_time    timestamp,
    is_deleted   boolean not null,
    text         varchar(2048),
    addressee_id int8,
    from_user_id int8,
    primary key (message_id)
);

create table usr
(
     user_id int8    not null,
     email varchar(255),
     password varchar(255),
     user_name varchar(255),
     last_visit timestamp,
     primary key (user_id)
);

alter table if exists addressee
    add constraint addressee_user
    foreign key (to_user_id)
    references usr;

alter table if exists message
    add constraint message_addressee
    foreign key (addressee_id)
    references addressee;

alter table if exists message
    add constraint message_user
    foreign key (from_user_id)
    references usr;
