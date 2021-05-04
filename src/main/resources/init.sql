create table bank
(
    id   bigint primary key identity,
    name varchar(250)
);

create table client
(
    passport_number bigint primary key,
    first_name      varchar(250),
    second_name     varchar(250),
    patronymic      varchar(250),
    phone           varchar(30),
    email           varchar(250) unique,

    bank_id         bigint references bank (id)
);

create table credit
(
    id         bigint primary key identity,
    "limit"    bigint,
    percentage float,

    bank_id    bigint references bank (id)
);

create table payment_graph
(
    id                 bigint primary key identity,
    "date"             date,
    total_payment      bigint,
    body_payment       bigint,
    percentage_payment bigint
);

create table credit_offer
(
    id               bigint identity,
    payment_amount   bigint,

    credit_id        bigint references credit (id),
    payment_graph_id bigint references payment_graph (id)
);
