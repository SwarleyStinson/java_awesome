CREATE TABLE IF NOT EXISTS nations
(
    name       VARCHAR(60) NOT NULL UNIQUE,
    side       VARCHAR(60),
    race       VARCHAR(60),
    population BIGINT
);

ALTER TABLE nations
    ADD CONSTRAINT constraint_name
        CHECK (
                    race NOTNULL NOT IN ('black')
                AND population > 0
            );