insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Zach', 'Smith', 'abc123', 'zsmith@smoothie.com', '1234567890', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Julie', 'Williams', 'def456', 'jwilliams@smoothie.com', '1234561234', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Sven', 'Bjergson', 'lol123', 'sbjergson@smoothie.com', '1234564321', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Allison', 'Johns', 'password123', 'ajohns@smoothie.com', '1234565566', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Michael', 'Pabst', 'pbr123', 'mpabst@smoothie.com', '1234561289', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('David', 'Anderson', 'dave123', 'danderson@smoothie.com', '1234165346', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Dana', 'Carter', 'fox123', 'dcarter@smoothie.com', '1234162146', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Ashley', 'Weston', 'wes123', 'aweston@smoothie.com', '1234165379', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Jason', 'Fredrick', 'pass123', 'jfredrick@smoothie.com', '1234165346', true);
insert into java301.users (first_name, last_name, password, email, phone_number, active) values ('Evelynn', 'Rogers', 'eve123', 'erogers@smoothie.com', '1234166269', true);

insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'zsmith@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'jwilliams@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'sbjergson@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'ajohns@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'mpabst@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'danderson@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'dcarter@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'aweston@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'jfredrick@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'erogers@smoothie.com'), 'USER');


insert into java301.ingredients (name, qty, price) values ('Orange', 10, .8);
insert into java301.ingredients (name, qty, price) values ('Banana', 10, .8);
insert into java301.ingredients (name, qty, price) values ('Apple', 10, .8);
insert into java301.ingredients (name, qty, price) values ('Pineapple', 10, .95);
insert into java301.ingredients (name, qty, price) values ('Peach', 10, .9);
insert into java301.ingredients (name, qty, price) values ('Milk', 30, 1.2);
insert into java301.ingredients (name, qty, price) values ('Ice', 30, 1.2);
insert into java301.ingredients (name, qty, price) values ('Strawberry', 10, .85);
insert into java301.ingredients (name, qty, price) values ('Avacado', 10, 1.15);
insert into java301.ingredients (name, qty, price) values ('Cucumber', 10, 1.1);
insert into java301.ingredients (name, qty, price) values ('Chicken Stock', 10, 1.75);
insert into java301.ingredients (name, qty, price) values ('Kale', 10, 1.2);
insert into java301.ingredients (name, qty, price) values ('Spinach', 10, .8);
insert into java301.ingredients (name, qty, price) values ('Carrot', 10, .55);
insert into java301.ingredients (name, qty, price) values ('Beet', 10, 1);
insert into java301.ingredients (name, qty, price) values ('Tomato', 10, .8);