CREATE TABLE product
(
    id              CHAR(36)        NOT NULL DEFAULT (UUID()),
    name            VARCHAR(255)   NOT NULL,
    description     TEXT           NOT NULL,
    stock           INTEGER        NOT NULL,
    price           numeric(16, 2) NOT NULL,
    small_image_url VARCHAR(255)   NOT NULL,
    big_image_url   VARCHAR(255)   NOT NULL,
    created_at      TIMESTAMP,
    id_category     CHAR(36) NOT NULL,
    deleted boolean NOT NULL DEFAULT false,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);
alter table product add constraint p_category_fk foreign key (id_category) references category(id);

CREATE INDEX ix_product_id_category ON product (id_category);