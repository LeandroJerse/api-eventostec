-- Migration para criar a tabela coupon
CREATE TABLE coupon (
    id UUID PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    discount NUMERIC(5,2) NOT NULL,
    expiration_date TIMESTAMP NOT NULL
);