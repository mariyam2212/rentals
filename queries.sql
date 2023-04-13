-- Drop the table if it exists
DROP TABLE IF EXISTS User_Type_Info CASCADE;
-- Create User_Type_Info table
CREATE TABLE User_Type_Info (
    user_type_id SERIAL PRIMARY KEY,
    user_type VARCHAR(50) NOT NULL
);
-- Insert values
INSERT INTO User_Type_Info (user_type)
VALUES ('Renter'),
       ('Agent');


-- Drop the table if it exists
DROP TABLE IF EXISTS Address_Info CASCADE;
-- Create Address_Info table
CREATE TABLE Address_Info (
    address_id SERIAL PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    zip_code VARCHAR(10) NOT NULL
);
-- Insert values
INSERT INTO Address_Info (street, city, country, zip_code)
VALUES ('123 Main St', 'New York', 'USA', '10001'),
       ('456 Elm St', 'Los Angeles', 'USA', '90001'),
       ('789 Oak St', 'Chicago', 'USA', '60616'),
       ('148 Langdon St', 'Madison', 'USA', '60616'),
       ('200 Michigan Ave', 'Chicago', 'USA', '60621'),
       ('344 Rhodes Ave', 'Chicago', 'USA', '60660');



-- Drop the table if it exists
DROP TABLE IF EXISTS User_Info CASCADE;
-- Create User_Info table
CREATE TABLE User_Info (
  user_id SERIAL PRIMARY KEY,
  email VARCHAR(255) UNIQUE,
  user_type_id INTEGER,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  address_id INTEGER,
  contact_no VARCHAR(15),
  job_type VARCHAR(255),
  agency_name VARCHAR(255),
  FOREIGN KEY (user_type_id) REFERENCES User_Type_Info (user_type_id),
  FOREIGN KEY (address_id) REFERENCES Address_Info (address_id)
);
-- Insert values
INSERT INTO User_Info (email, user_type_id, first_name, last_name, address_id, contact_no, job_type, agency_name)
VALUES ('user1@example.com', 1, 'John', 'Doe', 1, '1234567890', 'Developer', 'Agency 1'),
       ('user2@example.com', 2, 'Jane', 'Smith', 2, '9876543210', 'Designer', 'Agency 2'),
       ('user3@example.com', 1, 'Michael', 'Johnson', 3, '4567890123', 'Manager', 'Agency 3'),
       ('user4@example.com', 1, 'Sarah', 'Williams', 4, '7890123456', 'Administrator', 'Agency 4'),
       ('user5@example.com', 2, 'David', 'Brown', 5, '0123456789', 'Engineer', 'Agency 5'),
       ('user6@example.com', 1, 'Emily', 'Taylor', 6, '5432109876', 'Analyst', 'Agency 6');
     


-- Drop the table if it exists
DROP TABLE IF EXISTS Unit_Info CASCADE;
-- Create Unit_Info table
CREATE TABLE Unit_Info(
  UNIT_ID SERIAL PRIMARY KEY,
  UNIT_TITLE VARCHAR(4),
  UNIT_TYPE VARCHAR(20),
  PROPERTY_ID INT,
  FLOOR_NUMBER INT,
  NUMBER_OF_BEDS INT,
  NUMBER_OF_BATHROOMS INT,
  NUMBER_OF_BALCONY INT,
  SQUARE_FOOTAGE INT,
  AVAILABILITY_DATE DATE,
  RENT_AMOUNT INT
  );
-- Insert values
INSERT INTO Unit_Info (
  UNIT_TITLE,UNIT_TYPE,PROPERTY_ID,FLOOR_NUMBER,NUMBER_OF_BEDS,NUMBER_OF_BATHROOMS,
  NUMBER_OF_BALCONY,SQUARE_FOOTAGE,AVAILABILITY_DATE,RENT_AMOUNT)
  VALUES 
  ('3BHK','Apartment',0004,20,3,2,1,1000,'2023-05-01',1800),
  ('2BHK','House',0005,05,2,1,1,980,'2023-05-05',1400),
  ('1BHK','Apartment',0006,16,1,1,0,963,'2023-05-02',1167),
  ('NULL','Commercial_building',0001,NULL,NULL,NULL,NULL,2500,'2023-05-01',3000),
  ('3BHK','Apartment',0002,23,3,2,1,1200,'2023-05-11',1964);
 


-- Drop the table if it exists
DROP TABLE IF EXISTS Payment_Type_Info CASCADE;
-- Create Payment_Type_Info table
CREATE TABLE Payment_Type_Info (
PAYMENT_ID INT PRIMARY KEY,
PAYMENT_TYPE VARCHAR(25)
);
-- Insert values
INSERT INTO Payment_Type_Info (PAYMENT_ID,PAYMENT_TYPE)
VALUES
(1,'Debit'),
(2,'Credit');



-- Drop the table if it exists
DROP TABLE IF EXISTS Transaction_Info CASCADE;
-- Create Transaction_Info table
CREATE TABLE Transaction_Info (
  transaction_id SERIAL PRIMARY KEY,
  txn_amount DECIMAL(10,2),
  card_number VARCHAR(16),
  address_id INTEGER,
  payment_type_id INTEGER,
  txn_date DATE,
  txn_status VARCHAR(255),
  expiry_date DATE,
  FOREIGN KEY (address_id) REFERENCES Address_Info (address_id),
  FOREIGN KEY (payment_type_id) REFERENCES Payment_Type_Info (payment_id)
);
-- Insert values
INSERT INTO Transaction_Info (txn_amount, card_number, address_id, payment_type_id, txn_date, txn_status, expiry_date)
VALUES (100.00, '1234567890123456', 1, 1, '2023-04-01', 'Success', '2024-04-30'),
       (200.50, '9876543210987654', 2, 2, '2023-03-15', 'Pending', '2024-06-30'),
       (50.75, '4567890123456789', 3, 1, '2023-04-10', 'Success', '2023-09-30'),
       (75.25, '7890123456789012', 4, 1, '2023-04-05', 'Failed', '2023-11-30'),
       (300.00, '0123456789012345', 5, 2, '2023-04-08', 'Success', '2023-12-31'),
       (150.25, '5432109876543210', 6, 1, '2023-03-31', 'Pending', '2023-07-31');



-- Drop the table if it exists
DROP TABLE IF EXISTS Booking_Info CASCADE;
-- Create Booking_Info table
CREATE TABLE Booking_Info (
  booking_id SERIAL PRIMARY KEY,
  renter_id INTEGER,
  start_date DATE,
  end_date DATE,
  booking_unit_id INTEGER,
  booking_status VARCHAR(255),
  transaction_id INTEGER,
  FOREIGN KEY (renter_id) REFERENCES User_Info (user_id),
  FOREIGN KEY (booking_unit_id) REFERENCES Unit_Info (UNIT_ID),
  FOREIGN KEY (transaction_id) REFERENCES Transaction_Info (transaction_id)
);
-- Insert values
INSERT INTO Booking_Info (renter_id, start_date, end_date, booking_unit_id, booking_status, transaction_id)
VALUES (1, '2023-04-15', '2023-04-20', 3, 'Confirmed', 1),
       (2, '2023-04-18', '2023-04-22', 4, 'Pending', 2),
       (3, '2023-04-20', '2023-04-25', 1, 'Confirmed', 3),
       (2, '2023-04-28', '2023-05-02', 2, 'Confirmed', 5),
       (3, '2023-04-30', '2023-05-05', 5, 'Pending', 6);



-- Drop the table if it exists
DROP TABLE IF EXISTS Property_Info CASCADE;
-- Create Property_Info table
CREATE TABLE Property_Info (
 PROPERTY_ID INT PRIMARY KEY,
 PROPERTY_NAME VARCHAR(50),
 TOTAL_UNITS INT,
 TOTAL_FLOORS INT,
 STREET_NAME VARCHAR(25),
 CITY VARCHAR(25),
 STATE VARCHAR(25),
 COUNTRY VARCHAR(25),
 ZIP_CODE VARCHAR(10),
 ADDRESS VARCHAR(60),
 HAS_PARKING BOOLEAN,
 HAS_LAUNDRY BOOLEAN,
 IS_PET_FRIENDLY BOOLEAN,
 RATING INT
  );
-- Insert values
INSERT INTO Property_Info (PROPERTY_ID, PROPERTY_NAME, TOTAL_UNITS, TOTAL_FLOORS,
STREET_NAME,CITY,STATE,COUNTRY,ZIP_CODE,ADDRESS,HAS_PARKING,HAS_LAUNDRY,IS_PET_FRIENDLY,RATING)
VALUES
(0001,'vihari',10,20,'avenue','chicago','IL','US','60612','32_Street',TRUE,TRUE,FALSE,4),
(0002,'meadows',12,22,'michigan','chicago','IL','US','60616','33_Street',TRUE,TRUE,TRUE,4),
(0003,'shores',18,21,'portsun','chicago','IL','US','60612','35_Street',TRUE,TRUE,TRUE,5),
(0004,'rvrn',10,25,'roosevelt','chicago','IL','US','60616','31_Street',TRUE,FALSE,FALSE,3),
(0005,'bridgeport',15,25,'clark','chicago','IL','US','60616','32_Street',FALSE,TRUE,FALSE,4);



-- Drop the table if it exists
DROP TABLE IF EXISTS Property_Neighbourhood CASCADE;
-- Create the Property_Neighbourhood table
CREATE TABLE Property_Neighbourhood (
  property_id INTEGER PRIMARY KEY,
  nearest_grocery NUMERIC,
  nearest_school NUMERIC,
  nearest_bus_stop NUMERIC,
  nearest_metro NUMERIC,
  nearest_atm NUMERIC,
  nearest_airport NUMERIC,
  FOREIGN KEY (property_id) REFERENCES Property_Info (property_id)
);
-- Insert values
INSERT INTO Property_Neighbourhood (property_id, nearest_grocery, nearest_school, nearest_bus_stop, nearest_metro, nearest_atm, nearest_airport)
VALUES (1, 0.5, 1.2, 0.8, 3.5, 0.6, 12.7),
       (2, 1.0, 0.8, 1.2, 2.3, 1.1, 8.5),
       (3, 2.5, 1.5, 0.6, 4.1, 1.9, 15.0),
       (4, 0.8, 1.1, 1.0, 2.5, 0.7, 10.2),
       (5, 1.2, 0.7, 1.5, 3.0, 0.9, 9.8);



-- Drop the table if it exists
DROP TABLE IF EXISTS UNIT_FEATURES CASCADE;
-- Create UNIT_FEATURES table
CREATE TABLE UNIT_FEATURES (
UNIT_ID INT PRIMARY KEY,
HAS_HEATING BOOLEAN,
HAS_HARDWOOD_FLOOR BOOLEAN,
HAS_CARPET_FLOOR BOOLEAN,
HAS_PETS_ALLOWED BOOLEAN,
HAS_NO_OF_PARKING BOOLEAN
);
-- Insert values
INSERT INTO UNIT_FEATURES (UNIT_ID,HAS_HEATING,HAS_HARDWOOD_FLOOR,HAS_CARPET_FLOOR,HAS_PETS_ALLOWED,HAS_NO_OF_PARKING)
VALUES
(1010,TRUE,TRUE,FALSE,TRUE,FALSE),
(1011,TRUE,FALSE,TRUE,FALSE,TRUE),
(1012,FALSE,TRUE,TRUE,TRUE,FALSE),
(1013,FALSE,FALSE,FALSE,FALSE,TRUE);



    
    
