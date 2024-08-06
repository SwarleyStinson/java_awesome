CREATE FUNCTION get_leader(text) RETURNS SETOF leaders AS $$
    SELECT * FROM leaders WHERE nations = $1;
$$ LANGUAGE SQL;

DROP FUNCTION get_leader();

SELECT * FROM get_leader('Gondor') AS t1;

-- LATERAL for function
SELECT n.*, lead.name AS leader_name
FROM nations n
    LEFT JOIN LATERAL get_leader(n.name) lead ON TRUE
WHERE lead.name IS NULL;

-- LATERAL for subquery
SELECT n.*, lead.name AS leader_name
FROM nations n
    LEFT JOIN LATERAL (SELECT * FROM leaders WHERE nations = n.name) lead ON TRUE
WHERE lead.name IS NULL;

SELECT * FROM nations n
    LEFT JOIN leaders lead ON n.name = lead.nations
WHERE lead.name IS NULL;


select * from nations