BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('test_user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO customer (first_name,last_name,street_address,city,phone_number,user_id) VALUES ('Test First','Test Last','123 Test Street','Test City', '123-456-7890','3');

INSERT INTO sale (total,is_delivery,customer_id) VALUES ('420.00','TRUE','1');

INSERT INTO pizza (sale_id,size,pizza_name,sauce,crust,price,additional_instructions,is_visible) VALUES ('1',DEFAULT,'The Butcher','Marinara',DEFAULT,'30.00','Test instructions','TRUE');

INSERT INTO topping (topping_name,additional_price,is_visible,is_premium) VALUES ('pepperoni','1.25','TRUE','FALSE');

INSERT INTO pizza_topping (pizza_id,topping_name) VALUES ('1','pepperoni');

COMMIT TRANSACTION;
