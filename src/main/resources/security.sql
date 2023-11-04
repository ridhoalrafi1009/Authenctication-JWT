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

CREATE TABLE
    banner (
        id INT AUTO_INCREMENT PRIMARY KEY,
        bannerName VARCHAR(255) NOT NULL,
        bannerImage VARCHAR(255) NOT NULL,
        description VARCHAR(255) NOT NULL
    );

INSERT INTO
    banner (
        bannerName,
        bannerImage,
        description
    )
VALUES (
        'Banner 1',
        'https://nutech-integrasi.app/dummy.jpg',
        'Lerem Ipsum Dolor sit amet'
    ), (
        'Banner 2',
        'https://nutech-integrasi.app/dummy.jpg',
        'Lerem Ipsum Dolor sit amet'
    ), (
        'Banner 3',
        'https://nutech-integrasi.app/dummy.jpg',
        'Lerem Ipsum Dolor sit amet'
    ), (
        'Banner 4',
        'https://nutech-integrasi.app/dummy.jpg',
        'Lerem Ipsum Dolor sit amet'
    ), (
        'Banner 5',
        'https://nutech-integrasi.app/dummy.jpg',
        'Lerem Ipsum Dolor sit amet'
    ), (
        'Banner 6',
        'https://nutech-integrasi.app/dummy.jpg',
        'Lerem Ipsum Dolor sit amet'
    );

CREATE TABLE
    service (
        id INT AUTO_INCREMENT PRIMARY KEY,
        service_code VARCHAR(255) NOT NULL,
        service_name VARCHAR(255) NOT NULL,
        service_icon VARCHAR(255) NOT NULL,
        service_tarif INT(100) NOT NULL
    );

INSERT INTO
    service (
        service_code,
        service_name,
        service_icon,
        service_tarif
    )
VALUES (
        'PAJAK',
        'Pajak PBB',
        'https://nutech-integrasi.app/dummy.jpg',
        40000
    ), (
        'PLN',
        'Listrik',
        'https://nutech-integrasi.app/dummy.jpg',
        10000
    ), (
        'PDAM',
        'PDAM Berlangganan',
        'https://nutech-integrasi.app/dummy.jpg',
        40000
    ), (
        'PULSA',
        'Pulsa',
        'https://nutech-integrasi.app/dummy.jpg',
        40000
    ), (
        'PGN',
        'PGN Berlangganan',
        'https://nutech-integrasi.app/dummy.jpg',
        50000
    ), (
        'MUSIK',
        'Musik Berlangganan',
        'https://nutech-integrasi.app/dummy.jpg',
        50000
    ), (
        'TV',
        'TV Berlangganan',
        'https://nutech-integrasi.app/dummy.jpg',
        50000
    ), (
        'PAKET_DATA',
        'Paket data',
        'https://nutech-integrasi.app/dummy.jpg',
        50000
    ), (
        'VOUCHER_GAME',
        'Voucher Game',
        'https://nutech-integrasi.app/dummy.jpg',
        100000
    ), (
        'VOUCHER_MAKANAN',
        'Voucher Makanan',
        'https://nutech-integrasi.app/dummy.jpg',
        100000
    ), (
        'QURBAN',
        'Qurban',
        'https://nutech-integrasi.app/dummy.jpg',
        200000
    ), (
        'ZAKAT',
        'Zakat',
        'https://nutech-integrasi.app/dummy.jpg',
        300000
    );