REM Author Dylan Oszust
REM Created on 2/8/17
REM Guitar Builder Application DataBase
REM 
REM This DataBase is created to hold
REM information put in from the Custom Guitar Builder application.

REM Customer Table

CREATE TABLE Customer
(CustomerID NUMBER(5),
FirstName VARCHAR2(12),
LastName VARCHAR2(12),
Phone VARCHAR2(14),
Address VARCHAR2(50),
Email VARCHAR2(50),
ReturnCustomer CHAR(1),
CONSTRAINT Customer_ReturnCustomer_ck CHECK (ReturnCustomer in ('Y','N')),
CONSTRAINT Customer_CustomerID_pk PRIMARY KEY (CustomerID));

REM Neck Table

CREATE TABLE Neck
(NeckID Number(5),
NeckWood VARCHAR2(10),
FingerBoard VARCHAR2(10),
Scale NUMBER(4,2),
NumberOfFrets NUMBER(2),
NeckJoint VARCHAR2(12),
CONSTRAINT Neck_NeckID_pk PRIMARY KEY(NeckID));

REM Body Table

CREATE TABLE Body
(BodyID Number(5),
BodyWood VARCHAR2(10),
TopWood VARCHAR2(10),
BodyShape VARCHAR2(10),
CarveTop CHAR(1),
HollowBody CHAR(1),
CONSTRAINT Body_BodyID_pk PRIMARY KEY (BodyID),
CONSTRAINT Body_HollowBody_ck CHECK (HollowBody in ('Y','N')),
CONSTRAINT Customer_CarveTop_ck CHECK (CarveTop in ('Y','N')));

REM Hardware Table

CREATE TABLE Hardware
(HardwareID NUMBER(5),
NeckPickup VARCHAR2(30),
MiddlePickup VARCHAR2(30),
BridgePickup VARCHAR2(30),
ToneVolKnobs VARCHAR2(10),
Bridge VARCHAR2(10),
Tuners VARCHAR2(10),
CONSTRAINT Hardware_HardwareID_pk PRIMARY KEY(HardwareID));

REM Cosmetic TABLE

CREATE TABLE Cosmetic
(CosmeticID NUMBER(5),
BodyColor VARCHAR2(10),
NeckColor VARCHAR2(10),
HardwareColor VARCHAR2(10),
BindingColor  VARCHAR2(10),
FretMarkers CHAR(1),
MarkerType VARCHAR2(10),
MarkerColor VARCHAR2(10),
CONSTRAINT Cosmetics_CosmeticID_pk PRIMARY KEY(CosmeticID));

REM Product Table

CREATE TABLE Product
(ProductID NUMBER(5),
NeckID NUMBER(5),
BodyID NUMBER(5),
HardwareID NUMBER(5),
CosmeticID NUMBER(5),
CustomerID NUMBER(5),
Paid CHAR(1),
DateAdded Date DEFAULT SYSDATE,
CONSTRAINT Product_Char_ck CHECK (Paid in ('Y','N')),
CONSTRAINT Product_ProductID_pk PRIMARY KEY (ProductID),
CONSTRAINT Product_NeckID_fk FOREIGN KEY (NeckID)
REFERENCES Neck (NeckID) ON DELETE CASCADE,
CONSTRAINT Product_BodyID_fk FOREIGN KEY (BodyID)
REFERENCES Body (BodyID) ON DELETE CASCADE,
CONSTRAINT Product_HardwareID_fk FOREIGN KEY (HardwareID)
REFERENCES Hardware (HardwareID) ON DELETE CASCADE,
CONSTRAINT Product_CosmeticID_fk FOREIGN KEY (CosmeticID)
REFERENCES Cosmetic (CosmeticID) ON DELETE CASCADE,
CONSTRAINT Product_CustomerID_fk FOREIGN KEY (CustomerID)
REFERENCES Customer (CustomerID) ON DELETE CASCADE);

Commit;