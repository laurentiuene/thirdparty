DROP TABLE IF EXISTS payer;

CREATE TABLE payer (
  id_payer INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  card_number varchar(20) UNIQUE NOT NULL,
  card_expiring_date DATE NOT NULL,
  card_cvv varchar(10) NOT NULL,
  account_balance FLOAT NOT NULL,
  order_value FLOAT NOT NULL
);

INSERT INTO payer (first_name, last_name, card_number, card_expiring_date, card_cvv, account_balance, order_value) VALUES
 ('Laurentiu','Ene','0000000000000000','2025-12-08','069','1280.55','500.22');