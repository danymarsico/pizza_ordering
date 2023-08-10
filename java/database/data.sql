BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('test_user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO customer (first_name,last_name,street_address,city,phone_number,user_id) VALUES ('Test First','Test Last','123 Test Street','Test City', '123-456-7890',3);

INSERT INTO size (size_name, size_price) VALUES ('SMALL', 10.00);
INSERT INTO size (size_name, size_price) VALUES ('MEDIUM', 14.00);
INSERT INTO size (size_name, size_price) VALUES ('LARGE', 18.00);

INSERT INTO crust (crust_name, crust_price) VALUES ('Hand Tossed', 0.00);
INSERT INTO crust (crust_name, crust_price) VALUES ('Thin', 0.00);
INSERT INTO crust (crust_name, crust_price) VALUES ('Pan', 1.00);
INSERT INTO crust (crust_name, crust_price) VALUES ('Stuffed', 2.00);

INSERT INTO sauce (sauce_name, sauce_price) VALUES ('None', 0.00);
INSERT INTO sauce (sauce_name, sauce_price) VALUES ('Tomato', 0.00);
INSERT INTO sauce (sauce_name, sauce_price) VALUES ('Pesto', 0.75);
INSERT INTO sauce (sauce_name, sauce_price) VALUES ('Buffalo', 0.75);
INSERT INTO sauce (sauce_name, sauce_price) VALUES ('White Garlic', 0.75);

INSERT INTO specialty_pizza (pizza_name, pizza_desc) VALUES ('The Butcher', '');
INSERT INTO specialty_pizza (pizza_name, pizza_desc) VALUES ('The G.O.A.T.', '');
INSERT INTO specialty_pizza (pizza_name, pizza_desc) VALUES ('OG NAMELESS', '');
INSERT INTO specialty_pizza (pizza_name, pizza_desc) VALUES ('Playlist Deluxe', '');

INSERT INTO customer_order (total, is_delivery, date, customer_id) VALUES (75.00,TRUE,'2023-08-09', 1);
INSERT INTO customer_order (total,is_delivery,date,customer_id) VALUES ( 420.00,TRUE,'2023-07-26',1);


INSERT INTO pizza (additional_instructions, size_name, sauce_name, crust_name, order_id, price, order_status, specialty_id) VALUES ('Instructions',DEFAULT,'Tomato',DEFAULT,1,20.00,DEFAULT, NULL);
INSERT INTO pizza (additional_instructions, size_name, sauce_name, crust_name, order_id, price, order_status, specialty_id) VALUES ('Instructions',DEFAULT,'Tomato',DEFAULT,1,14.00,DEFAULT, NULL);
INSERT INTO pizza (additional_instructions, size_name, sauce_name, crust_name, order_id, price, order_status, specialty_id) VALUES ('Instructions',DEFAULT, DEFAULT, DEFAULT,2,44.00,DEFAULT, 1);

INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('pepperoni',1.25,FALSE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('sausage',1.25,FALSE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('ham',1.25,FALSE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('olive',1.25,FALSE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('green pepper',1.25,FALSE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('onion',1.25,FALSE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('egg',1.25,FALSE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('gold leaf',20.00,TRUE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('chanterelle mushroom',2.25,TRUE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('black truffle',2.25,TRUE);
INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('prosciutto',2.25,TRUE);


INSERT INTO pizza_topping (pizza_id,topping_name) VALUES (1,'pepperoni');
INSERT INTO pizza_topping (pizza_id,topping_name) VALUES (2,'ham');
INSERT INTO pizza_topping (pizza_id,topping_name) VALUES (2,'olive');

INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (1,'prosciutto');
INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (1,'pepperoni');
INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (1,'sausage');
INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (1,'ham');

INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (2,'olive');
INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (2,'green pepper');
INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (2,'onion');
INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (2,'chanterelle mushroom');

INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (3,'black truffle');
INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (3,'gold leaf');

INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (4,'egg');

COMMIT TRANSACTION;

