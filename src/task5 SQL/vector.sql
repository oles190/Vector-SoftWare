CREATE DATABASE MyShop;
USE MyShop;



CREATE TABLE IF NOT EXISTS Suppliers
(
    supplier_id int primary key,
    name        varchar(120),
    city        varchar(100),
    country     varchar(100)
);

CREATE TABLE IF NOT EXISTS Categories
(
    categories_id int primary key,
    name          varchar(100),
    description   varchar(200)
);
CREATE TABLE IF NOT EXISTS Products
(
    product_id    int auto_increment not null primary key,
    supplier_id   int,
    categories_id int,
    name          varchar(120)       not null,
    foreign key (supplier_id) references Suppliers (supplier_id),
    foreign key (categories_id) references Categories (categories_id),
    price         double             not null

);

INSERT INTO Suppliers(supplier_id, name, city, country)
VALUES (1, 'Exotic Liquid', 'London', 'UK'),
       (2, 'New Orleans Cajun Delights', 'New Orleans', 'USA'),
       (3, 'Grandma Kelly’s Homestead', 'Ann Arbor', 'USA'),
       (4, 'Tokyo Traders', 'Tokyo', 'Japan'),
       (5, 'Cooperativa de Quesos ‘Las Cabras’', 'Oviedo', 'Spain');


INSERT INTO Categories(categories_id, name, description)
VALUES (1, 'Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
       (2, 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
       (3, 'Confections', 'Desserts, candies, and sweet breads'),
       (4, 'Dairy Products', 'Cheeses'),
       (5, 'Grains/Cereals', 'Breads, crackers, pasta, and cereal');

INSERT INTO Products (supplier_id, categories_id, name, price)
VALUES (1, 1, 'Chais', 18.00),
       (1, 1, 'Chang', 19.00),
       (1, 2, 'Aniseed Syrup', 10.00),
       (2, 2, 'Chef Anton’s Cajun Seasoning', 22.00),
       (2, 2, 'Chef Anton’s Gumbo Mix', 21.35);


# Select product with product name that begins with 'C'
SELECT *
from Products
where name like 'C%';

# Select product with the smallest price.
SELECT *
from Products
where price = (select min(price) from Products);

# Select cost of all products from the USA.
SELECT product_id, Products.name, categories_id, price, country
from Products
         left join Suppliers on
    Products.supplier_id = Suppliers.supplier_id
where country = 'USA';

#  Select suppliers that supply Condiments.
SELECT Suppliers.supplier_id, Suppliers.name, city, country, Categories.categories_id, Categories.name
from Products
         left join Suppliers on Products.supplier_id = Suppliers.supplier_id
         left join Categories on Products.categories_id = Categories.categories_id
where Categories.name = 'Condiments';


# Add to database new supplier with name: 'Norske Meierier', city: 'Lviv',
# country: 'Ukraine' which will supply new product with name: 'Green tea', price: 10, and related to category with name: 'Beverages'.

INSERT INTO Suppliers(supplier_id, name, city, country)
VALUES (6, 'Norske Meierier', 'Lviv', 'UK');


INSERT INTO Products (supplier_id, categories_id, name, price)
VALUES (6, 1, 'Green tea', 10.00);