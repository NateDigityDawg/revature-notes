
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