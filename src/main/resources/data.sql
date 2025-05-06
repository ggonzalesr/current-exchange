-- Usuario admin con password "password" encriptado
INSERT INTO users (username, password, role) VALUES 
('admin', '$2b$12$8MZFKYvjw5Ye7SUU7X.ecuCnJP33Rlk05sYzEhebSnc6NDyhKOIo6', 'ADMIN');

-- Tasas de cambio iniciales
INSERT INTO exchange_rates (from_currency, to_currency, rate) VALUES
('USD', 'PEN', 3.75),
('PEN', 'USD', 0.27),
('EUR', 'PEN', 4.10),
('PEN', 'EUR', 0.24);