CREATE TABLE users
(
    id        serial primary key,
    login     varchar(35) unique,
    password  varchar(35),
    is_online boolean
);