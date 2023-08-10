BEGIN TRANSACTION;

DROP TABLE IF EXISTS specialty_topping, pizza_topping, topping, pizza, customer_order, specialty_pizza, crust, sauce, size, customer, users;

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

CREATE TABLE size (
    size_name varchar(15) PRIMARY KEY,
    size_price numeric(6,2)
);

CREATE TABLE sauce (
    sauce_name varchar(15) PRIMARY KEY,
    sauce_price numeric(6,2)
);

CREATE TABLE crust (
    crust_name varchar(15) PRIMARY KEY,
    crust_price numeric(6,2)
);

CREATE TABLE specialty_pizza (
    specialty_id SERIAL PRIMARY KEY,
    pizza_name varchar(50) NOT NULL UNIQUE,
    pizza_desc varchar(300) NOT NULL
);

CREATE TABLE customer_order (
    order_id SERIAL PRIMARY KEY,
    total numeric(6,2),
    is_delivery boolean NOT NULL,
    date date NOT NULL,
    customer_id int NOT NULL REFERENCES customer(customer_id)
);

CREATE TABLE pizza (
    pizza_id SERIAL PRIMARY KEY,
    additional_instructions varchar(500),
    size_name varchar(15) DEFAULT('LARGE') NOT NULL REFERENCES size(size_name) ,
    sauce_name varchar(15)DEFAULT('No Sauce') NOT NULL REFERENCES sauce(sauce_name),
    crust_name varchar(15) DEFAULT('Hand Tossed') NOT NULL REFERENCES crust(crust_name),
    order_id int NOT NULL REFERENCES customer_order(order_id),
    price numeric(6,2) NOT NULL,
    order_status varchar(10) DEFAULT('Pending') NOT NULL,
    specialty_id int REFERENCES specialty_pizza(specialty_id)
);

CREATE TABLE topping (
    topping_name varchar(50) PRIMARY KEY,
    additional_price numeric(6,2),
    is_premium boolean NOT NULL
);

CREATE TABLE pizza_topping (
    pizza_id int NOT NULL REFERENCES pizza(pizza_id),
    topping_name varchar(50) NOT NULL REFERENCES topping(topping_name),
    CONSTRAINT pk_pizza_topping PRIMARY KEY (pizza_id, topping_name)
);

CREATE TABLE specialty_topping (
    specialty_id int NOT NULL REFERENCES specialty_pizza(specialty_id),
    topping_name varchar(50) NOT NULL REFERENCES topping(topping_name)
);

COMMIT TRANSACTION;
