CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(80) NOT NULL UNIQUE,
    email VARCHAR(160) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL,
    enabled BOOLEAN NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE refresh_tokens (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    token_hash VARCHAR(128) NOT NULL UNIQUE,
    expires_at TIMESTAMP WITH TIME ZONE NOT NULL,
    revoked BOOLEAN NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE customers (
    id UUID PRIMARY KEY,
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    email VARCHAR(160) NOT NULL UNIQUE,
    phone VARCHAR(30) NOT NULL,
    document_number VARCHAR(50) NOT NULL UNIQUE,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE bank_accounts (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL REFERENCES customers(id),
    account_number VARCHAR(34) NOT NULL UNIQUE,
    type VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    balance NUMERIC(19,2) NOT NULL,
    opened_at TIMESTAMP WITH TIME ZONE NOT NULL,
    closed_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    source_account_id UUID REFERENCES bank_accounts(id),
    target_account_id UUID REFERENCES bank_accounts(id),
    type VARCHAR(30) NOT NULL,
    amount NUMERIC(19,2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    description VARCHAR(255),
    created_by VARCHAR(80) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE audit_logs (
    id UUID PRIMARY KEY,
    username VARCHAR(80),
    http_method VARCHAR(10) NOT NULL,
    endpoint VARCHAR(255) NOT NULL,
    operation VARCHAR(120) NOT NULL,
    status_code INTEGER NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE INDEX idx_accounts_customer ON bank_accounts(customer_id);
CREATE INDEX idx_transactions_source ON transactions(source_account_id);
CREATE INDEX idx_transactions_target ON transactions(target_account_id);
CREATE INDEX idx_audit_created_at ON audit_logs(created_at);
