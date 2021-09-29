DROP TABLE IF EXISTS EXCHANGE_RATE;

CREATE TABLE EXCHANGE_RATE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  origin_currency VARCHAR(5) NOT NULL,
  destination_currency VARCHAR(5) NOT NULL,
  rate DECIMAL(10,2) NOT NULL,
  trading_date DATE NOT NULL
);

INSERT INTO EXCHANGE_RATE (origin_currency, destination_currency, rate, trading_date) VALUES
('SOL', 'SOL', 1, now()),
('SOL', 'DOL', 0.24, now()),
('SOL', 'EUR', 0.21, now()),
('DOL', 'DOL', 1, now()),
('DOL', 'SOL', 4.12, now()),
('DOL', 'EUR', 0.86, now()),
('EUR', 'EUR', 1, now()),
('EUR', 'SOL', 4.82, now()),
('EUR', 'DOL', 1.17, now());