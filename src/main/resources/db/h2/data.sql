INSERT INTO customers (email, first_name, last_name) VALUES ('nick@piggybank.com', 'Nick', 'Dala');
INSERT INTO customers (email, first_name, last_name) VALUES ('sue@piggybank.com', 'Sue', 'Something');
INSERT INTO customers (email, first_name, last_name) VALUES ('joe@piggybank.com', 'Joe', 'Foo');

INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='nick@piggybank.com'), 'SAVINGS', 110356, 'ACTIVE');
INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='nick@piggybank.com'), 'CHECKING', 10589, 'ACTIVE');

INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='sue@piggybank.com'), 'SAVINGS', 20280, 'ACTIVE');
INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='sue@piggybank.com'), 'CREDIT', 105609, 'ACTIVE');

INSERT INTO accounts (customer_id, account_type, balance, account_status) VALUES ((SELECT customer_id from customers WHERE email='joe@piggybank.com'), 'CHECKING', 34576, 'ACTIVE');
