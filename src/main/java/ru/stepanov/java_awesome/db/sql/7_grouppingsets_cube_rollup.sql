CREATE VIEW total_sales AS
SELECT
       product_id,
       p.name,
       s.size,
       (sum(s.units) * (p.price - p.cost)) AS profit
FROM products p
         LEFT JOIN sales s USING (product_id)
WHERE s.date BETWEEN '2020-01-01 12:00:00' AND '2021-01-01 12:00:00'
GROUP BY product_id, p.name, p.price, p.cost, s.size

-- GROUPING SETS
SELECT
    ts.name,
    ts.size,
    sum(ts.profit)
from total_sales ts
group by grouping sets ((ts.name), (ts.size), ())  -- () - все строки сводятся к одной группе
order by ts.name, ts.size;                         -- можно (ts.name, ts.size)

-- ROLLUP
SELECT
    ts.name,
    ts.size,
    sum(ts.profit)
from total_sales ts
group by rollup (ts.name, ts.size)
order by ts.name, ts.size NULLS FIRST ;

-- CUBE
SELECT
    ts.name,
    ts.size,
    sum(ts.profit)
from total_sales ts
group by cube (ts.name, ts.size) -- все возможные подмножества
order by ts.name, ts.size NULLS FIRST ;