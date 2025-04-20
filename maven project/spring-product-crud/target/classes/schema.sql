CREATE TABLE product (
    id SERIAL PRIMARY KEY, -- SERIAL for auto-increment in PostgreSQL
    name VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    quantity INT NOT NULL,
    model VARCHAR(255) NOT NULL
);

