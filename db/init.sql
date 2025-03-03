CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE CASCADE
);

INSERT INTO users (username, password, role) VALUES
('admin', 'admin123', 'ADMIN'),
('user', 'user123', 'USER');
