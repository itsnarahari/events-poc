# Turn FK checks off so we can drop the table  (session)
SET foreign_key_checks = 0;

# Drop   
DROP TABLE WFM_AVAIL_EVENTS;

# Create new table:
CREATE TABLE WFM_AVAIL_EVENTS
(
  EVENT_ID          int NOT NULL AUTO_INCREMENT PRIMARY KEY
 ,DIVN              int NOT NULL
 ,EVENTNAME         VARCHAR(255)           NOT NULL
 ,START_DTM         DATETIME               NOT NULL
 ,END_DTM           DATETIME               NOT NULL
 ,DISPLAY_START_DTM DATETIME               NOT NULL
 ,DISPLAY_END_DTM   DATETIME               NOT NULL
 ,ALLOW_CHGS        VARCHAR(1)             DEFAULT 'N'
 ,CREATE_DATE       DATETIME               NOT NULL
 ,LAST_UPDATED_BY   VARCHAR(50)
 ,LAST_UPDATE       DATETIME               NOT NULL  
);

#INDEXES:  Primary key is already created above if AUTO_INCREMENT is used!

#CONSTRAINTS - Not needed for PRIMARY key;  Used to guarantee uniqueness
ALTER TABLE WFM_AVAIL_EVENTS ADD CONSTRAINT UC_WFM_AVAIL_EVENTS_DIVNAME UNIQUE (DIVN,EVENTNAME);

#SYNONYMS:  not really supported in MySQL

#GRANTS:  - Add grants beyond the creating owner: Need to include individual statements for each object, e.g.   table, sequence, view, etc;
#GRANT SELECT ON WFM.WFM_AVAIL_EVENTS TO GCP_USER_1;

#INSERT: A test record
INSERT INTO WFM_AVAIL_EVENTS VALUES (NULL,71,'THANKSGIVING 2022',STR_TO_DATE('11/21/2022 00:00:00','%m/%d/%Y %H:%i:%s'),STR_TO_DATE('11/22/2022 00:00:00','%m/%d/%Y %H:%i:%s'),STR_TO_DATE('10/01/2022 00:00:00','%m/%d/%Y %H:%i:%s'),STR_TO_DATE('10/30/2022 00:00:00','%m/%d/%Y %H:%i:%s'),'N',NOW(),'B06JXH',NOW());
INSERT INTO WFM_AVAIL_EVENTS VALUES (NULL,71,'INVENTORY 2022',STR_TO_DATE('01/01/2023 00:00:00','%m/%d/%Y %H:%i:%s'),STR_TO_DATE('01/01/2023 00:00:00','%m/%d/%Y %H:%i:%s'),STR_TO_DATE('10/01/2023 00:00:00','%m/%d/%Y %H:%i:%s'),STR_TO_DATE('12/01/2023 00:00:00','%m/%d/%Y %H:%i:%s'),'N',NOW(),'B06JXH',NOW());

# Reenable FK check
SET foreign_key_checks = 1;

#Autocommit may or may not be turned on
COMMIT;

SELECT * FROM WFM_AVAIL_EVENTS ORDER BY 1;






 


