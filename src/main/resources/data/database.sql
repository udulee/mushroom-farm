Database
Queries

SHOW DATABASES;
DROP
DATABASE IF EXISTS mushroom;
CREATE
DATABASE mushroom;
USE
mushroom;

DROP TABLE IF EXISTS Quality_check;
DROP TABLE IF EXISTS Employee_farm_house;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS farm_house;
DROP TABLE IF EXISTS mushroom_batch;
DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Deliver;
DROP TABLE IF EXISTS pay;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Feedback;
DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer
(
    customer_id INT PRIMARY KEY,
    First_name  VARCHAR(100) NOT NULL,
    Last_name   VARCHAR(100) NOT NULL,
    email       VARCHAR(100) UNIQUE,
    contact     CHAR(15),
    Address     VARCHAR(200) NOT NULL
);

CREATE TABLE Feedback
(
    feedback_id INT PRIMARY KEY,
    customer_id INT,
    rating      VARCHAR(100) NOT NULL,
    comment     VARCHAR(200) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

CREATE TABLE Orders
(
    order_id       INT PRIMARY KEY,
    customer_id    INT,
    payment_status VARCHAR(100)   NOT NULL,
    order_date     DATE           NOT NULL,
    total_amount   DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

CREATE TABLE Pay
(
    payment_id     INT PRIMARY KEY,
    order_id       INT,
    payment_Method VARCHAR(100)   NOT NULL,
    payment_date   DATE           NOT NULL,
    amount         DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders (order_id)
);

CREATE TABLE Deliver
(
    deliver_id   INT PRIMARY KEY,
    order_id     INT,
    customer_id  INT,
    Order_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders (order_id),
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

CREATE TABLE Product
(
    product_id   INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    quantity     VARCHAR(100) NOT NULL
);

CREATE TABLE order_product
(
    order_product_id INT PRIMARY KEY,
    order_id         INT,
    product_id       INT,
    quantity         VARCHAR(100)   NOT NULL,
    sub_total        DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders (order_id),
    FOREIGN KEY (product_id) REFERENCES Product (product_id)
);

CREATE TABLE farm_house
(
    farm_id  INT PRIMARY KEY,
    location VARCHAR(100) NOT NULL,
    size     VARCHAR(100) NOT NULL
);

CREATE TABLE mushroom_batch
(
    batch_id        INT PRIMARY KEY,
    farm_id         INT,
    customer_id     INT,
    mushroom_type   VARCHAR(100) NOT NULL,
    quantity        VARCHAR(100) NOT NULL,
    quantity_status VARCHAR(100) NOT NULL,
    FOREIGN KEY (farm_id) REFERENCES farm_house (farm_id),
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

CREATE TABLE Employee
(
    employee_id INT PRIMARY KEY,
    First_name  VARCHAR(100)   NOT NULL,
    Last_name   VARCHAR(100)   NOT NULL,
    email       VARCHAR(100) UNIQUE,
    contact     CHAR(15),
    salary      DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Employee_farm_house
(
    employee_id INT,
    farm_id     INT,
    PRIMARY KEY (employee_id, farm_id),
    FOREIGN KEY (employee_id) REFERENCES Employee (employee_id),
    FOREIGN KEY (farm_id) REFERENCES farm_house (farm_id)
);

CREATE TABLE Quality_check
(
    check_id   INT PRIMARY KEY,
    batch_id   INT,
    status     VARCHAR(100) NOT NULL,
    check_date DATE         NOT NULL,
    notes      VARCHAR(200) NOT NULL,
    FOREIGN KEY (batch_id) REFERENCES mushroom_batch (batch_id)
);

INSERT INTO Customer
VALUES (101, 'Himali', 'Piumika', 'himalipals@gmail.com', '0712755023', 'KDE 311, Ranajayapura, Ipalogama'),
       (102, 'Nimal', 'Perera', 'nimalp@gmail.com', '0774523412', 'Green Avenue, Colombo'),
       (103, 'Sajith', 'Fernando', 'sajithf@yahoo.com', '0701234567', 'Lake View, Kandy'),
       (104, 'Anushka', 'Senarath', 'anushkasena@gmail.com', '0712458974', 'Temple Road, Kurunegala'),
       (105, 'Dilani', 'Wickrama', 'dilanistyle@gmail.com', '0765521147', 'Main Street, Galle');

INSERT INTO Feedback
VALUES (202, 101, '*****',
        'The mushrooms were incredibly fresh and flavorful. Loved the organic packaging too. Will definitely order again!'),
       (202, 102, '****', 'Tasty, but delivery was late.'),
       (203, 103, '*****', 'Fresh and clean. Loved it!'),
       (204, 104, '***', 'Okay product, packing could improve.'),
       (205, 105, '****', 'Good value for money.');

INSERT INTO Orders
VALUES (303, 101, 'Payment successfully received', '2025-03-28', 1500.00),
       (302, 102, 'Pending', '2025-04-01', 1200.00),
       (303, 103, 'Paid', '2025-04-02', 1800.00),
       (304, 104, 'Paid', '2025-04-03', 1000.00),
       (305, 105, 'Cancelled', '2025-04-04', 950.00);
INSERT INTO Pay
VALUES (404, 303, 'Cash on Delivery (COD)', '2025-03-30', 1000.00),
       (302, 102, 'Pending', '2025-04-01', 1200.00),
       (303, 103, 'Paid', '2025-04-02', 1800.00),
       (304, 104, 'Paid', '2025-04-03', 1000.00),
       (305, 105, 'Cancelled', '2025-04-04', 950.00);
INSERT INTO Deliver
VALUES (505, 303, 101, 2500.00),
       (402, 303, 'Bank Transfer', '2025-04-02', 1800.00),
       (403, 304, 'Credit Card', '2025-04-03', 1000.00),
       (404, 302, 'Not Paid', '2025-04-01', 0.00),
       (405, 305, 'Refunded', '2025-04-05', 950.00);

INSERT INTO Product
VALUES (606, 'Family Pack', 101, 1000.00),
       (502, 302, 102, 1200.00),
       (503, 303, 103, 1800.00),
       (504, 304, 104, 1000.00),
       (505, 305, 105, 950.00);

INSERT INTO order_product
VALUES (707, 303, 606, '1kg', 1500.00),
       (602, 'Oyster Mushroom - 1kg', 607, '2kg', 2500.00),
       (603, 'Shiitake Mushroom - 250g', 608, '2.5kg', 3000.00),
       (604, 'Enoki Mushroom - 500g', 609, '1.5kg', 2000.00),
       (605, 'Mixed Mushroom Box - 1kg', 610, '1kg', 1500.00);

INSERT INTO farm_house
VALUES (909, 'No. 45, New Kandy Road, Malabe', '1kg'),
       (702, 'No. 12, New Kandy Road, Malabe', 'Large', '1kg', 1200.00),
       (703, 'Green Valley Estate, Bandarawela', 'Medium', '250g', 1800.00),
       (704, 'No. 55, Lake Road, Kurunegala', 'Small', '500g', 1000.00),
       (705, 'Hilltop Farm, Nuwara Eliya', 'Medium', '1kg', 950.00);

INSERT INTO mushroom_batch
VALUES (808, 909, 101, 'Button Mushroom', '1kg', 'Available'),
       (802, 902, 102, 'Oyster Mushroom', '1kg', 'Harvested'),
       (803, 903, 103, 'Shiitake Mushroom', '250g', 'Available'),
       (804, 904, 104, 'Enoki Mushroom', '500g', 'Processing'),
       (805, 905, 105, 'Mixed', '1kg', 'Ready');
INSERT INTO Employee
VALUES (1001, 'Lanka', 'Nayana', 'nayanapals@gmail.com', '0770810834', 60000.00),
       (1002, 'Kamal', 'Jayasinghe', 'kamaljay@gmail.com', '0769876543', 55000.00),
       (1003, 'Nirosha', 'Senanayake', 'nirosha_sena@gmail.com', '0753214789', 62000.00),
       (1004, 'Sunil', 'Dias', 'sunild@gmail.com', '0773415587', 58000.00),
       (1005, 'Ishara', 'Peris', 'isharap@gmail.com', '0758896412', 61000.00)
    INSERT
INTO Employee_farm_house
VALUES
    (1001, 909), (1002, 902), (1003, 903), (1004, 904), (1005, 905);


INSERT INTO Quality_check
VALUES (2002, 808, 'Passed', '2025-03-25', 'Meets all standards'),
       (2002, 802, 'Pending', '2025-04-01', 'Awaiting lab result'),
       (2003, 803, 'Passed', '2025-04-02', 'Perfect quality'),
       (2004, 804, 'Failed', '2025-04-03', 'Humidity too high'),
       (2005, 805, 'Passed', '2025-04-04', 'Ready for shipping');

