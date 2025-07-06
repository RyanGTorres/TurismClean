CREATE TABLE tursim(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    identifier VARCHAR(255) NOT NULL UNIQUE,
    turism_start TIMESTAMP NOT NULL,
    turism_end TIMESTAMP NOT NULL,
    localization VARCHAR(255),
    capacity INTEGER NOT NULL,
    enterprise VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL
);