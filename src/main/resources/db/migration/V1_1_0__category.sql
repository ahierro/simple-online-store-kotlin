CREATE TABLE category
(
    id              CHAR(36)        NOT NULL DEFAULT (UUID()),
    name            VARCHAR(50)   NOT NULL,
    description     TEXT           NOT NULL,
    created_at      TIMESTAMP,
    deleted boolean NOT NULL DEFAULT false,
    CONSTRAINT category_pkey PRIMARY KEY (id)
);