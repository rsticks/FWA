DROP TABLE IF EXISTS users;

CREATE TABLE    users(
    id              SERIAL NOT NULL CONSTRAINT PK_USERS PRIMARY KEY,
    phone_number    varchar(254) UNIQUE NOT NULL ,
    password        varchar(100) NOT NULL ,
    first_name      varchar(254) NOT NULL ,
    last_name       varchar(254)
);