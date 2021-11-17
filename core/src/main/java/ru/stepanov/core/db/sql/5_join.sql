CREATE TABLE IF NOT EXISTS leaders
(
    name    VARCHAR(50) UNIQUE,
    nations VARCHAR(50),
    power   BIGINT,
    CHECK ( name NOTNULL AND nations NOTNULL AND power > 0)
);
INSERT INTO leaders VALUES ('Sauron', 'Mordor Orks', 500);
DROP TABLE leaders;

-- ON
SELECT n.*,
       l.name  AS leader,
       l.power AS leader_power
FROM nations n
         LEFT JOIN leaders l ON n.name = l.nations
-- USING
SELECT biggest.*
FROM (SELECT * FROM nations WHERE population > 30000) AS biggest
         INNER JOIN (SELECT * FROM nations WHERE side = 'light') AS light_side USING (name);
-- CROSS JOIN
SELECT biggest.*
FROM (SELECT * FROM nations WHERE population > 30000) AS biggest
         INNER JOIN (SELECT * FROM nations WHERE side = 'light') AS light_side USING (name);