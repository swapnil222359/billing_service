

# removed foreign keys as its showing me errors for updating the data base
#we can add it whenever we need them
CREATE TABLE menu
(
    itemID int(32),
    item_name varchar(255),
    quantity varchar(255),
    price DECIMAL(5,2),
    resID int (232),
    type VARCHAR(100),
    PRIMARY KEY (itemID)
);
CREATE TABLE coupon
(
    coupon_id VARCHAR(255),
    coupon_name varchar(255),
    offer_description VARCHAR(255),
    creation_date VARCHAR(50),
    validity VARCHAR(50),
    percentage int(10),
    total DECIMAL(9,2),
    item_id int(32),
    restaurant_id int (32),
    points int (16),
    points_type VARCHAR(255),
    offer_type VARCHAR(255),
    redeem BOOLEAN,
    PRIMARY KEY (coupon_id)
);

CREATE TABLE user (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(30), email_id VARCHAR(30), mobile_number BIGINT, address VARCHAR(50), restaurant_id INT, PRIMARY KEY (id), FOREIGN KEY(restaurant_id) references restaurant(restaurant_id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE table_details
(
    itemID int(32),
    quantity int(16),
    tableID int(32),
    resID int (32),
    PRIMARY KEY (tableID,resID,itemID)
);

CREATE TABLE rif
(
    ResID int(11),
    Name varchar(255),
    Address varchar(255),
    Number int(10),
    EmailID VARCHAR(255)

);

CREATE TABLE PointsAlloted
(
    resID int(32),
    userID int(32),
    points int(32),
    points_type VARCHAR(100),
    serialNumber int(32),

    PRIMARY KEY (serialNumber),
    FOREIGN KEY (resID) REFERENCES rif(ResID)
);

CREATE TABLE login_details
(
    loginid VARCHAR(255),
    password varchar(255),
    resid int (20),
    srNum int(30)
);
ALTER TABLE tabledetails
    ADD PRIMARY KEY (tableID,resID);

CREATE TABLE transaction_details
(
    Id int(32)NOT NULL AUTO_INCREMENT,
    itemID int(32),
    trID int(32),
    quantity int(16),
    PRIMARY KEY (Id)

);

CREATE TABLE transaction
(
    trID int (32) NOT NULL AUTO_INCREMENT,
    total int(20),
    resID int (32),
    tableID int (32),
    payment_type VARCHAR(100),
    paymentID int(16),
    couponID int(32),
    userID int(32),
    timestamp TIMESTAMP,
    PRIMARY KEY (trID)
);



#below queries for alter only if needed
DELETE FROM rif WHERE ResID=1;
ALTER TABLE login_details
    ADD PRIMARY KEY (srNum);

SELECT * FROM REST;

RENAME TABLE rest to RIF;

ALTER TABLE tabledetails
    ADD trID int(32);

ALTER TABLE menu
    CHANGE qty quantity VARCHAR(100);

ALTER TABLE menu
    MODIFY COLUMN Number int(10);

INSERT INTO menu
VALUES (1,"Psycho@ad.com","dsf",354.2,1);

ALTER TABLE menu
    DROP COLUMN itemi;

SELECT * FROM menu;

DROP TABLE table_details;

ALTER TABLE transaction_details
    DROP COLUMN qty;
INSERT INTO transaction(trid,resid,tableID)
    VALUES (1,1,2);

INSERT INTO table_details(tableID,itemID,resID,quantity)
VALUES (3,1,1,3);
INSERT INTO table_details(tableID,itemID,resID,quantity)
VALUES (2,2,1,2);
INSERT INTO table_details(tableID,itemID,resID,quantity)
VALUES (2,3,1,3);
INSERT INTO table_details(tableID,itemID,resID,quantity)
VALUES (2,4,1,1);
INSERT INTO table_details(tableID,itemID,resID,quantity)
VALUES (2,1,1,2);


INSERT INTO menu(itemID,item_name,price,quantity,resid,type)
VALUES (1,"menu1",50,"full",1,"main");

INSERT INTO menu(itemID,item_name,price,quantity,resid,type)
VALUES (2,"menu2",50,"full",1,"main");
INSERT INTO menu(itemID,item_name,price,quantity,resid,type)
VALUES (3,"menu3",50,"half",1,"beverages");
INSERT INTO menu(itemID,item_name,price,quantity,resid,type)
VALUES (4,"menu4",50,"full",1,"starter");
INSERT INTO menu(itemID,item_name,price,quantity,resid,type)
VALUES (5,"menu5",50,"full",1,"starter");

SELECT * FROM table_details ;