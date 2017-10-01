
CREATE TABLE menu
(
    itemID int,
    item_name varchar(255),
    qty varchar(255),
    price DECIMAL(5,2),
    resid int (20)

);
CREATE TABLE CouponDetails
(
    couponID VARCHAR(255),
    coupon_name varchar(255),
    offer_description VARCHAR(255),
    creation_date TIMESTAMP,
    validity TIMESTAMP,
    percentage int(10),
    total DECIMAL(9,2),
    itemID int(32),
    resID int (32),
    points int (16),
    points_type VARCHAR(255),
    offer_type VARCHAR(255),
    redeem BOOLEAN,
    PRIMARY KEY (couponID),
    FOREIGN KEY (resID) REFERENCES rif(ResID),
    FOREIGN KEY (itemID) REFERENCES menu(itemID)
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
ALTER TABLE login_details
    ADD PRIMARY KEY (srNum);

CREATE TABLE transaction_details
(
    itemID int,
    trid int(20),
    qty VARCHAR(255)

);

CREATE TABLE transaction
(
    trid int (20),
    total int(20),
    resid int (20),
    date DATE,
    time TIME

);



#below queries for alter only if needed
DELETE FROM rif WHERE ResID=1;
ALTER TABLE login_details
    ADD PRIMARY KEY (srNum);

SELECT * FROM REST;

RENAME TABLE rest to RIF;

ALTER TABLE menu
    ADD comboID VARCHAR(255);

ALTER TABLE menu
    CHANGE qty quantity VARCHAR(100);

ALTER TABLE menu
    MODIFY COLUMN Number int(10);

INSERT INTO menu
VALUES (1,"Psycho@ad.com","dsf",354.2,1);

ALTER TABLE rif
    DROP COLUMN password;

SELECT * FROM menu;

DROP TABLE pet;