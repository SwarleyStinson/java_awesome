WITH unit_price AS (
  select p.product_id, p.price from products p
), most_wanted AS (
    SELECT
           s.product_id,
           sum(units) AS saled_units,
           (sum(units) * up.price) AS total_price
    FROM sales s
        left join unit_price up using (product_id)
    GROUP BY s.product_id, up.price
    HAVING (sum(units) * up.price) > 40000
)
select
       p2.name,
       mw.saled_units,
       mw.total_price
from most_wanted mw left join products p2 using (product_id)
;

select * from sales