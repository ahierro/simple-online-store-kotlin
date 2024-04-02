create table purchase_order
(
    id         CHAR(36) NOT NULL DEFAULT (UUID()),
    id_user    CHAR(36) not null,
    status     VARCHAR(50) NOT NULL,
    total      numeric(16, 2) NOT NULL,
    created_at TIMESTAMP,
    CONSTRAINT purchase_order_pkey PRIMARY KEY (id)
);
alter table purchase_order add constraint po_id_user_fk foreign key (id_user) references users (id);

create table purchase_order_line
(
    id         CHAR(36) NOT NULL DEFAULT (UUID()),
    id_purchase_order CHAR(36) not null,
    id_product CHAR(36) not null,
    quantity   INTEGER not null,
    CONSTRAINT purchase_order_lines_pkey PRIMARY KEY (id)
);
alter table purchase_order_line add constraint po_id_product_fk foreign key (id_product) references product (id);
alter table purchase_order_line add constraint po_id_purchase_order_fk foreign key (id_purchase_order) references purchase_order (id);
create unique index uix_purchase_order_line on purchase_order_line (id_purchase_order, id_product);
