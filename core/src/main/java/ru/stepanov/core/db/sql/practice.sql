CREATE TABLE IF NOT EXISTS nations
(
    name       VARCHAR(60) NOT NULL UNIQUE,
    side       VARCHAR(60),
    population BIGINT
);

-- CRUD
INSERT INTO nations VALUES('Gondor', 'light', 50000);
UPDATE nations SET population = 55000  WHERE name = 'Gondor';
DELETE FROM nations WHERE side NOT IN ('dark', 'light');
SELECT * FROM nations n;

ALTER TABLE nations
    ADD CONSTRAINT constraint_name
        CHECK (
                    side NOTNULL NOT IN ('black')
                AND population > 0
            );

UPDATE nations
SET population = population * 1.15
WHERE population <= 60000
RETURNING name, population AS new_population;