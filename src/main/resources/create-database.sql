create table BANK
(
    ID   BIGINT not null primary key,
    NAME VARCHAR(250)
);

create table CLIENT
(
    PASSPORT_NUMBER BIGINT not null primary key,
    EMAIL           VARCHAR(255),
    FIRST_NAME      VARCHAR(250),
    PATRONYMIC      VARCHAR(250),
    PHONE           VARCHAR(255),
    SECOND_NAME     VARCHAR(250)
);

create table CREDIT
(
    ID      BIGINT not null primary key,
    LIMIT   BIGINT not null,
    EBALA   DOUBLE not null,
    BANK_ID BIGINT not null
        constraint FK1X1IAF0DSP6S1TJHDIHHEDGDK references BANK on delete cascade
);

create table CREDIT_OFFER
(
    ID                     BIGINT not null primary key,
    PAYMENT_AMOUNT         BIGINT not null,
    CLIENT_PASSPORT_NUMBER BIGINT not null
        constraint FKTNQJ8XWQX96LAOB6CDCR3BG5M references CLIENT on delete cascade,
    CREDIT_ID              BIGINT not null
        constraint FKNVC9MQGYQ6PTBUMJ35EDCGF4I references CREDIT on delete cascade
);

create table PAYMENT_GRAPH_ELEMENT
(
    ID                 BIGINT not null primary key,
    BODY_PAYMENT       BIGINT not null,
    DATE               DATE   not null,
    PERCENTAGE_PAYMENT BIGINT not null,
    TOTAL_PAYMENT      BIGINT not null
);

create table CREDIT_OFFER_PAYMENT_GRAPH
(
    CREDIT_OFFER_ID  BIGINT not null
        constraint FK130F0HO153KQ9EULIJLHDEJRY references CREDIT_OFFER on delete cascade,
    PAYMENT_GRAPH_ID BIGINT not null unique
        constraint FKP7P17G9GW2KY4RX0FNKPYL49R references PAYMENT_GRAPH_ELEMENT on delete cascade
);
