BEGIN TRANSACTION;

DROP TABLE IF EXISTS specialty_topping, pizza_topping, topping, current_pizza, specialty_pizza, order, customer, users;

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
    phone_number varchar(15) NOT NULL,
    user_id int NOT NULL REFERENCES users(user_id)
);

CREATE TABLE order (
    order_id SERIAL PRIMARY KEY,
    total numeric(6,2),
    is_delivery boolean NOT NULL,
    date date NOT NULL,
    is_active boolean NOT NULL,
    customer_id int NOT NULL REFERENCES customer(customer_id)
);

CREATE TABLE specialty_pizza (
    specialty_id SERIAL PRIMARY KEY,
    price numeric(4,2) NOT NULL,
    pizza_name varchar(50) NOT NULL UNIQUE
);

CREATE TABLE current_pizza (
    pizza_id SERIAL PRIMARY KEY,
    order_id int NOT NULL REFERENCES sale(sale_id),
    size varchar(10) DEFAULT('Large') NOT NULL ,
    pizza_name varchar(50) NOT NULL UNIQUE,
    sauce varchar(10),
    crust varchar(15) DEFAULT('Hand Tossed') NOT NULL,
    price numeric(4,2) NOT NULL,
    specialty_id int NOT NULL REFERENCES specialty_pizza(specialty_id),
    additional_instructions varchar(500),
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

CREATE TABLE specialty_topping (
    specialty_id int NOT NULL REFERENCES specialty_pizza(specialty_id),
    topping_name varchar(15) NOT NULL REFERENCES topping(topping_name)
);

COMMIT TRANSACTION;
