
CREATE TABLE IF NOT EXISTS users (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
    );


INSERT INTO users (id, name, age, email, password, role)
VALUES (UUID(), 'John Doe', 30, 'kenyjohn@example.com', 'secure password', 'USER');

INSERT INTO users (id, name, age, email, password, role)
VALUES (UUID(), 'Karen Indie', 32, 'karen@example.com', '123 password', 'USER');


SELECT * FROM users;

SELECT * FROM users WHERE email = 'kenyjohn@example.com';

DELETE FROM users WHERE email = 'kenyjohn@example.com';

DELETE FROM users WHERE email = 'karen@example.com';