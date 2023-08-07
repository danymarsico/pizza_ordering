BEGIN TRANSACTION;

DROP TABLE IF EXISTS pizza_topping, topping, pizza, sale, customer, users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE customer (
    customer_id SERIAL PRIMARY KEY,
    first_name varchar(20) NOT NULL,
    last_name varchar(20) NOT NULL,
    street_address varchar(50),
    city varchar(50),
    phone_number varchar(10) NOT NULL,
    user_id int NOT NULL REFERENCES users(user_id)
);

CREATE TABLE sale (
    sale_id SERIAL PRIMARY KEY,
    total numeric(6,2),
    is_delivery boolean NOT NULL,
    customer_id int NOT NULL REFERENCES customer(customer_id)
);

CREATE TABLE pizza (
    pizza_id SERIAL PRIMARY KEY,
    sale_id int REFERENCES sale(sale_id),
    size varchar(10) DEFAULT('Large'),
    pizza_name varchar(50) NOT NULL UNIQUE,
    sauce varchar(10),
    crust varchar(10) DEFAULT('Hand Tossed'),
    price numeric(4,2) NOT NULL,
    additional_instructions varchar(500),
    is_visible boolean NOT NULL DEFAULT (TRUE)
);

CREATE TABLE topping (
    topping_name varchar(15) PRIMARY KEY,
    additional_price numeric(3,2),
    is_visible boolean NOT NULL,
    is_premium boolean NOT NULL
);

CREATE TABLE pizza_topping (
    pizza_id int NOT NULL REFERENCES pizza(pizza_id),
    topping_name varchar(15) NOT NULL REFERENCES topping(topping_name),
    CONSTRAINT pk_pizza_topping PRIMARY KEY (pizza_id, topping_name)
);

COMMIT TRANSACTION;
