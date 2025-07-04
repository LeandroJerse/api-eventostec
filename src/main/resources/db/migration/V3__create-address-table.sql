-- Migration para criar a tabela address
CREATE TABLE address (
    id UUID PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    event_id UUID NOT NULL,
    FOREIGN KEY (event_id) REFERENCES event(id) ON DELETE CASCADE
);
