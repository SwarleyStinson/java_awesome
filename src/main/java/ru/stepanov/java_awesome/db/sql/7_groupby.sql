SELECT n.side,
       sum(population) AS total_population
FROM nations n
WHERE n.population > 100
GROUP BY n.side
HAVING sum(population) > 100000

CREATE TABLE products
(
    name       VARCHAR(50),
    product_id VARCHAR(50),
    price      BIGINT,
    cost       BIGINT
)
INSERT INTO products
VALUES ('Hoody', '2222', 340, 100)

CREATE TABLE sales
(
    product_id VARCHAR(50),
    date       TIMESTAMP,
    units      INT
);
INSERT INTO sales
VALUES ('5678', '2021-01-01 08:19:12', 120, 'M');

SELECT
       product_id,
       p.name,
--        p.price,
--        p.cost,
--        sum(s.units)
       (sum(s.units) * (p.price - p.cost)) AS profit
FROM products p
         LEFT JOIN sales s USING (product_id)
WHERE s.date BETWEEN '2020-01-01 12:00:00' AND '2021-01-01 12:00:00'
GROUP BY product_id, p.name, p.price, p.cost
HAVING sum(p.price * s.units) > 5000;
