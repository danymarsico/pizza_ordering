BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('test_user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO customer (first_name,last_name,street_address,city,phone_number,user_id) VALUES ('Test First','Test Last','123 Test Street','Test City', '123-456-7890',3);

INSERT INTO customer_order (total,is_delivery,date, is_active,customer_id) VALUES ( 420.00,'TRUE','2023-07-26','TRUE',1);

INSERT INTO specialty_pizza (price,pizza_name) VALUES ( 20.00,'The Butcher');

INSERT INTO current_pizza (order_id,size,pizza_name,sauce,crust,price,specialty_id,additional_instructions) VALUES (1,DEFAULT,'The Butcher','Marinara',DEFAULT,20.00,1,'Please do not add onions');

INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('pepperoni',1.25,FALSE);

INSERT INTO topping (topping_name,additional_price,is_premium) VALUES ('prosciutto',2,TRUE);

INSERT INTO pizza_topping (pizza_id,topping_name) VALUES (1,'pepperoni');

INSERT INTO specialty_topping (specialty_id,topping_name) VALUES (1,'prosciutto');

COMMIT TRANSACTION;

