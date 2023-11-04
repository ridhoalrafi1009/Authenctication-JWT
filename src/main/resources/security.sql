-- Active: 1698846544911@@127.0.0.1@3306@security

CREATE TABLE
    users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        firstName VARCHAR(255) NOT NULL,
        lastName VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL
    );

CREATE TABLE
    userProfile (
        firstName VARCHAR(255) NOT NULL,
        lastName VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        profil_image VARCHAR(255) NOT NULL
    );

UPDATE userProfile
SET
    profil_image = 'https://yoururlapi.com/profile.jpeg'
WHERE email = 'ridho@gmail.com';

SELECT firstName, lastName
FROM users
WHERE email = 'ridho@gmail.com'