
create table address
(
    address_id  serial
        constraint address_pk
            primary key,
    address     varchar(250) not null,
    postal_code integer      not null,
    status      integer
);

alter table address
    owner to postgres;

create table author
(
    author_id serial
        constraint author_pk
            primary key,
    name      varchar(250) not null
);

alter table author
    owner to postgres;

create table category
(
    category_id serial
        constraint category_pk
            primary key,
    category    varchar(250) not null
);

alter table category
    owner to postgres;

create table client
(
    client_id  serial
        constraint client_pk
            primary key,
    name       varchar(250) not null,
    lastname   varchar(250) not null,
    email      varchar(250) not null,
    phone      integer      not null,
    address_id integer      not null
        constraint client_address
            references address,
    status     integer
);

alter table client
    owner to postgres;

create table editorial
(
    editorial_id serial
        constraint editorial_pk
            primary key,
    editorial    varchar(250) not null
);

alter table editorial
    owner to postgres;

create table book
(
    book_id      serial
        constraint book_pk
            primary key,
    title        varchar(250) not null,
    release_date date         not null,
    author_id    integer      not null
        constraint book_author
            references author,
    editorial_id integer      not null
        constraint book_editorial
            references editorial,
    language     varchar(250) not null,
    pages        serial,
    description  varchar(250) not null,
    book_cover   varchar(250) not null,
    status       integer      not null
);

alter table book
    owner to postgres;

create table book_category
(
    id_book_category serial
        constraint book_category_pk
            primary key,
    book_id          integer not null
        constraint book_category_book
            references book,
    category_id      integer not null
        constraint book_category_category
            references category,
    book_category_id integer not null
);

alter table book_category
    owner to postgres;

create table loan
(
    loan_id     serial
        constraint loan_pk
            primary key,
    client_id   integer not null
        constraint loan_client
            references client,
    book_id     integer not null
        constraint loan_book
            references book,
    loan_date   date    not null,
    return_date date    not null
);

alter table loan
    owner to postgres;

