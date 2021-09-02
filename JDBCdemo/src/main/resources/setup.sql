
DROP TYPE IF EXISTS nathanl.user_role CASCADE;
CREATE TYPE nathanl.user_role AS ENUM ('Admin', 'Employee', 'Customer');

DROP TABLE IF EXISTS nathanl.users, nathanl.accounts, nathanl.users_accounts_jt, nathanl.applications CASCADE;
CREATE TABLE nathanl.users(
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role nathanl.user_role NOT NULL
);

CREATE TABLE nathanl.accounts(
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES nathanl.users(id),
	active BOOLEAN DEFAULT FALSE --- this IS determining whether the account has been activated
);

CREATE TABLE nathanl.users_accounts_jt(
	acc_owner INTEGER NOT NULL REFERENCES nathanl.users(id),
	account INTEGER NOT NULL REFERENCES nathanl.accounts(id)
);

CREATE TABLE nathanl.applications(
	id SERIAL PRIMARY KEY,
	app_owner INTEGER NOT NULL REFERENCES nathanl.users(id)
);


	


-- We need to trigger an insert of the necessary data INTO the users_account_jt,
-- WHENEVER an account is inserted into the accounts table


/**
 * PL/pgSQL procedural language adds many procedural elements,
 * e.g., control structures, loops, and complex computations,
 * to extend standard SQL. It allows you to insert elements automatically into a table...
 */

-- Create the function to insert elements of a new account record into
-- the users_account_jt taable
CREATE OR REPLACE FUNCTION nathanl.auto_insert_into_jt() RETURNS TRIGGER AS 
$BODY$
BEGIN 
	INSERT INTO nathanl.users_accounts_jt(acc_owner, account)
	VALUES(NEW.acc_owner, NEW.id);
		RETURN NEW;
END
$BODY$u
LANGUAGE plpgsql;

-- set the trigger so that every time a new row is inserted into the account
-- table it automatically populates the users_accounts_jt table;
CREATE TRIGGER trig
	AFTER INSERT ON nathanl.accounts 
	FOR EACH ROW 
	EXECUTE PROCEDURE nathanl.auto_insert_into_jt();

TRUNCATE TABLE nathanl.users CASCADE;
TRUNCATE TABLE nathanl.accounts CASCADE;

INSERT INTO nathanl.users (username, pwd, user_role)
VALUES ('Larry', 'secret', 'Employee'),
('Mary', '1234', 'Customer'),
('Barry', 'pass', 'Customer');

INSERT INTO nathanl.accounts (balance, acc_owner)
	VALUES (100, 1), (200, 2), (2000, 2), (300, 3);


SELECT * FROM nathanl.users;
SELECT * FROM nathanl.accounts;
SELECT * FROM nathanl.users_accounts_jt;


	
-- JOIN from the accounts table and the users_accoutn_jt WHERE the accowner_id is the same as the userID
SELECT nathanl.accounts.id, nathanl.accounts.balance 
FROM nathanl.accounts 
INNER JOIN nathanl.users_accounts_jt 
ON nathanl.accounts.id = nathanl.users_accounts_jt.account
WHERE nathanl.users_accounts_jt.acc_owner = 2;