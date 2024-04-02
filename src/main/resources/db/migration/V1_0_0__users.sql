CREATE TABLE users
(
    id         CHAR(36)        NOT NULL DEFAULT (UUID()),
    username   VARCHAR(50)     NOT NULL,
    password   VARCHAR(500)    NOT NULL,
    email      VARCHAR(50)     NOT NULL,
    first_name VARCHAR(100)    NOT NULL,
    last_name  VARCHAR(100)    NOT NULL,
    active     BOOLEAN         NOT NULL DEFAULT TRUE,
    locked     BOOLEAN         NOT NULL DEFAULT FALSE,
    authorities JSON           NOT NULL,
    created_at TIMESTAMP,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

create unique index ix_users_username on users (username);
create unique index ix_users_email on users (email);