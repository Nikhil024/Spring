--------------------------------------------------------
--  File created - Friday-January-13-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "NIKHIL"."USERS" 
   (	"ID" NUMBER(*,0), 
	"NAME" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(500 BYTE), 
	"PASSWORD" VARCHAR2(500 BYTE), 
	"USER_TYPE" VARCHAR2(50 BYTE), 
	"EMAIL_VERIFIED" VARCHAR2(5 BYTE), 
	"ADMIN_ACCEPTED" VARCHAR2(5 BYTE), 
	"LAST_LOGIN" DATE, 
	"LAST_UPDATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C0010763
--------------------------------------------------------

  CREATE UNIQUE INDEX "NIKHIL"."SYS_C0010763" ON "NIKHIL"."USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "NIKHIL"."USERS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;

  CREATE SEQUENCE  "NIKHIL"."USERS_ID"  MINVALUE 1 MAXVALUE 1000000 INCREMENT BY 1 START WITH 41 CACHE 20 ORDER  CYCLE ;
  
  
  
  --------------------------------------------------------
--  DDL for Trigger USERS_UP_INS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "NIKHIL"."USERS_UP_INS" 
   BEFORE INSERT OR UPDATE
   ON USERS
   REFERENCING NEW AS new OLD AS old
   FOR EACH ROW
DECLARE
BEGIN
   :new.LAST_UPDATE   := SYSDATE;
EXCEPTION
   WHEN OTHERS
   THEN
      -- Consider logging the error and then re-raise
      RAISE;
END USERS_UP_INS;
/
ALTER TRIGGER "NIKHIL"."USERS_UP_INS" ENABLE;


CREATE TABLE EMAILLINKENCRYPTION(ID NUMBER REFERENCES USERS(ID),EMAIL VARCHAR2(900),NAME VARCHAR2(500),LAST_UPDATE DATE);





  CREATE OR REPLACE TRIGGER "NIKHIL"."EMAILLINKENCRYPTION_INS" 
   BEFORE INSERT OR UPDATE
   ON EMAILLINKENCRYPTION
   REFERENCING NEW AS new OLD AS old
   FOR EACH ROW
DECLARE
BEGIN
   :new.LAST_UPDATE   := SYSDATE;
EXCEPTION
   WHEN OTHERS
   THEN
      -- Consider logging the error and then re-raise
      RAISE;
END EMAILLINKENCRYPTION_INS;
/
ALTER TRIGGER "NIKHIL"."EMAILLINKENCRYPTION_INS" ENABLE;



CREATE TABLE IMAGES (ID INT REFERENCES USERS(ID),IMAGES_NAME VARCHAR(255),IMAGES_LOCATION VARCHAR(900),UPLOADED_DATE DATE,LAST_UPDATE DATE,PRIMARY KEY(ID));

  CREATE OR REPLACE TRIGGER IMAGES_INS
   BEFORE INSERT OR UPDATE
   ON IMAGES
   REFERENCING NEW AS new OLD AS old
   FOR EACH ROW
DECLARE
BEGIN
   :new.LAST_UPDATE   := SYSDATE;
EXCEPTION
   WHEN OTHERS
   THEN
      -- Consider logging the error and then re-raise
      RAISE;
END IMAGES_INS;
/
ALTER TRIGGER IMAGES_INS ENABLE;