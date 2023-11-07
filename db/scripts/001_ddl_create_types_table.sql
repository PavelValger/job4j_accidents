create table types
(
    id   serial primary key,
    type_name text not null unique
);