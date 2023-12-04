INSERT INTO customers (email, first_name, last_name) VALUES ('nick@piggybank.com', 'Nick', 'Dala');
INSERT INTO customers (email, first_name, last_name) VALUES ('chris@piggybank.com', 'Chris', 'Something');
INSERT INTO customers (email, first_name, last_name) VALUES ('sandy@piggybank.com', 'Sandy', 'Foo');

INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='nick@piggybank.com'), 'SAVINGS', 110356, 'ACTIVE');
INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='nick@piggybank.com'), 'CHECKING', 10589, 'ACTIVE');
INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='nick@piggybank.com'), 'CREDIT', 925634, 'ACTIVE');

INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='chris@piggybank.com'), 'SAVINGS', 20280, 'ACTIVE');
INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='chris@piggybank.com'), 'CREDIT', 105609, 'ACTIVE');

INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='sandy@piggybank.com'), 'CHECKING', 34576, 'ACTIVE');
