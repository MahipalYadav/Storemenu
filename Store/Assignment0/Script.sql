drop table  if exists menu;
create table menu  (
id  serial primary key,
itemname  varchar(30) not null unique, 
item varchar(30) not null,
quantity  numeric (20) not null,
amount  numeric (9,2) not null,
available  varchar (20) not null
);

insert into menu (itemname, item, quantity, amount, available) values
('M&M','Candy',  12, 1.99,'Yes'),
('Laffy Taffy', 'Candy', 6, 1.99,'No'),
('Redbull', 'EnergyDrink', 13, 2.29,'Yes'),
('5hrs','Energy drink', 45, 2.99,'No'),
('Rice','Food', 23, 8.99,'No');
