-- users table
CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL
);

-- Test data
INSERT INTO users (username, password) VALUES 
  ('testuser1', 'pass123'),
  ('testuser2', 'pass456'),
  ('testuser3', 'pass789');
