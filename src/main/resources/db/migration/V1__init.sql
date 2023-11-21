create table accounts(
    account_id bigserial not null,
    customer_id bigint,
    balance bigint not null,
    account_status varchar(255) check (account_status in ('ACTIVE','CLOSED')),
    account_type varchar(255) check (account_type in ('SAVINGS','CHECKING','CREDIT')),
    primary key (account_id)
);

create table customers(
    customer_id bigserial not null,
    email varchar(255) not null unique,
    first_name varchar(255),
    last_name varchar(255),
    primary key (customer_id)
);

alter table if exists accounts add constraint FKn6x8pdp50os8bq5rbb792upse foreign key (customer_id) references customers;
