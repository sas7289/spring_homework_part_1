BEGIN;

DROP TABLE IF EXISTS shoppers CASCADE;
CREATE TABLE shoppers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO shoppers (name) VALUES
('Antony'),
('Elena'),
('Johan');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost bigint);
INSERT INTO products (title, cost) VALUES
('bread', 30),
('beer', 65),
('meet', 460);

DROP TABLE IF EXISTS products_shoppers CASCADE;
CREATE TABLE products_shoppers (id bigserial PRIMARY KEY, product_id bigint references products(id), shopper_id bigint references shoppers(id));
INSERT INTO products_shoppers (product_id, shopper_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 3),
(3, 3);

COMMIT;