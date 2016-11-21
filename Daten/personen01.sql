CREATE TABLE personen (
  person_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1), 
  person_name     VARCHAR(20),
  person_alter    INT               
)
;

ALTER TABLE personen ADD CONSTRAINT pk_personen_id PRIMARY KEY (person_id)
;

INSERT INTO personen (person_name, person_alter) 
VALUES ('Mustermann, Max', 45)
;

SELECT * FROM personen
;