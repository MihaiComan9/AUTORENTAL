INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(1,'Lamborghini Aventador',3,'Yellow',1)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(2,'Ferrari 458 Italia',3,'Red',0)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(3,'Bentley Continental',3,'White',0)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(4,'Mercedes-Benz S500',5,'Black',2)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(5,'Mercedes-Benz E320',5,'Grey',1)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(6,'B.M.W. 335 xDrive',3,'Blue',1)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(7,'B.M.W. x5 M50D',5,'White',5)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(8,'Skoda Superb',5,'Grey',4)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(9,'Renault Megane',5,'Green',7)
INSERT INTO CAR(id,car_name,nr_Of_Doors,color,quantity) VALUES(10,'Peugeot RCZ',5,'Red',5)


INSERT INTO FACTORY(id,email,factory_name,founding_year) VALUES(1,"FPP@gmail.com","Benz Factory",1985)

INSERT INTO role(role_id, name) VALUES (1, 'ROLE_ADMIN')
INSERT INTO my_user(user_id, enabled, email, full_name, username, password, account_non_expired, account_non_locked, credentials_non_expired) VALUES (999, 1, 'hi.mihai@yahoo.com', 'Mihai', 'salut', '$2a$10$NppHU3gZ5Z1MKnVwduB3POYR4HJWnvYG2.q54JUVWaZgPP7TnzPYq', true, true, true)
INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (999, 1)