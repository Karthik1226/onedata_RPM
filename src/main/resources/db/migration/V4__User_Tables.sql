Create TYPE role AS ENUM ('admin', 'patient', 'doctor');

Create TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    roles role NOT NULL
);