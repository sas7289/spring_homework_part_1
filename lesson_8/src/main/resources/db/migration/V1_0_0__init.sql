create table categories
(
    id   serial primary key,
    name varchar(255)
);

insert into categories (name)
values ('Продукты'),
       ('Одежда'),
       ('Обувь'),
       ('Бытовая химия'),
       ('Продукты'),
       ('Лекартсва'),
       ('Игрушки'),
       ('Косметика')
;

create table products
(
    id          serial primary key,
    category_id bigint references categories (id),
    title       varchar(255),
    cost        int
);

insert into products (title, cost, category_id)
values ('bread', 50, 1),
       ('meet', 460, 1),
       ('beer', 65, 1),
       ('honey', 370, 1),
       ('lemon', 100, 1),
       ('cheese', 350, 1),
       ('tomato', 240, 1),
       ('apple', 145, 1),
       ('juice', 100, 1),
       ('cake', 400, 1),
       ('salad', 65, 1);

create table users
(
    id       serial primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    email    varchar(255) unique,
    unique (username, password)
);

insert into users
    (username, password, email)
values ('test', '$2y$10$aip8imAKKBzRConPWdBh2.4F.Y42bhf6LZmNz02llM5JG3ivMrc0u', 'test');

create table roles
(
    id   serial primary key,
    name varchar(255) not null
);
insert into roles
(name)
values ('USER');

create table users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into users_roles
(user_id, role_id)
values (1,1);

create table users_products
(
    user_id bigint not null references users(id),
    product_id bigint not null references products(id),
    primary key (user_id, product_id)
);

create table order_item
(
    id           serial,
    title        varchar(255),
    productId    bigint,
    productPrice int,
    quantity     int
);
insert into order_item
    (title, productId, productPrice, quantity)
values ('bread', 1, 50, 2),
       ('meet', 2, 460, 1),
       ('beer', 3, 65, 3);



