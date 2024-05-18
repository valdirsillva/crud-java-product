CREATE DATABASE db_products;

CREATE TABLE product (
    id VARCHAR(60) NOT NULL PRIMARY KEY,
    name VARCHAR(90),
    price FLOAT(9, 2) NOT NULL,
    quantity INTEGER,
    description TEXT,
    createdAt DATETIME DEFAULT CURRENT_TIMESTAMP
)

INSERT INTO
    product (
        name,
        price,
        quantity,
        description
    )
VALUES (?, ?, ?, ?)