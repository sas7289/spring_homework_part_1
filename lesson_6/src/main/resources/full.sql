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

DROP TABLE IF EXISTS purchase_history CASCADE;
CREATE TABLE purchase_history (id bigserial PRIMARY KEY, shopper_id bigint references shoppers(id),
 product_id bigint references products(id), cost bigint);
INSERT INTO purchase_history (shopper_id, product_id, cost) VALUES
(1, 1, 30),
(2, 1, 30),
(3, 1, 30),
(1, 2, 65),
(3, 2, 65),
(3, 3, 460);

COMMIT;