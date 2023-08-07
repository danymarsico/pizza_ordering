BEGIN TRANSACTION;

DROP TABLE IF EXISTS pizza, users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE pizza (
    pizza_id SERIAL PRIMARY KEY,
    --sale_id int REFERENCES sale(sale_id),
    size varchar(10) DEFAULT('Large'),
    pizza_name varchar(50) NOT NULL UNIQUE,
    sauce varchar(10),
    crust varchar(10) DEFAULT('Hand Tossed'),
    price numeric(4,2) NOT NULL,
    additional_instructions varchar(500),
    is_visible boolean NOT NULL DEFAULT (TRUE)
);

COMMIT TRANSACTION;
