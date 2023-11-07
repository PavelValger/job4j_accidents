create table rules
(
    id   serial primary key,
    rule_name text not null unique
);