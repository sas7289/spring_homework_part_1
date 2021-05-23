create table products
(
    id    serial primary key,
    title varchar(255),
    cost  int
);

insert into products (title, cost)
values ('bread', 50),
       ('meet', 460),
       ('beer', 65),
       ('honey', 370),
       ('lemon', 100),
       ('cheese', 350),
       ('tomato', 240),
       ('apple', 145),
       ('juice', 100),
       ('cake', 400),
       ('salad', 65);