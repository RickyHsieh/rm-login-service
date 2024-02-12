DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
                           member_id SERIAL PRIMARY KEY,
                           last_name VARCHAR(20) NOT NULL,
                           first_name VARCHAR(20) NOT NULL,
                           username VARCHAR(20) NOT NULL,
                           cust_id VARCHAR(20) NOT NULL,
                           contact_number VARCHAR(20) NOT NULL,
                           email_address VARCHAR(50) NOT NULL,
                           account_verified VARCHAR(2),
                           role VARCHAR(20) NOT NULL,
                           pwd VARCHAR(50) NOT NULL,
                           third_party_auth_type VARCHAR(100),
                           third_party_auth_id VARCHAR(100),
                           create_at VARCHAR(50),
                           last_login_time VARCHAR(50)
);

CREATE TABLE customers_authorities (
                                       id SERIAL PRIMARY KEY,
                                       customer_id INTEGER NOT NULL,
                                       authority VARCHAR(50) NOT NULL,
                                       CONSTRAINT fk_customer
                                           FOREIGN KEY (customer_id)
                                               REFERENCES customers (member_id)
                                               ON DELETE CASCADE
);


INSERT INTO customers (
    last_name,
    first_name,
    username,
    cust_id,
    contact_number,
    email_address,
    account_verified,
    role,
    pwd,
    third_party_auth_type,
    third_party_auth_id,
    create_at,
    last_login_time
) VALUES (
             'Ricky',
             'Mars',
             'rm123',
             'E123456789',
             '1234567890',
             'rickyHsieh@example.com',
             '1',
             'ROLE_USER',
             'mysecretpassword',
             NULL,
             NULL,
             '2024-02-10 00:00:00',
             NULL
         );

-- INSERT INTO customers_authorities (member_id, authority) VALUES
--                                                              (7, 'ROLE_ADMIN'),
--                                                              (7, 'ROLE_USER');