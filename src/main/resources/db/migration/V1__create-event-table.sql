CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE event (
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    img_url VARCHAR(100) NOT NULL,
    event_url VARCHAR(255) NOT NULL,
    date TIMESTAMP NOT NULL,
    remote BOOLEAN NOT NULL
);
