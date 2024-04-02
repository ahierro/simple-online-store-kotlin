CREATE VIEW purchase_order_view AS
SELECT
    po.id as id,
    po.id_user as id_user,
    po.total as total,
    po.status as status,
    po.created_at as created_at,
    u.email as email,
    u.username as username,
    u.first_name as first_name,
    u.last_name as last_name
FROM purchase_order po INNER JOIN users u on u.id = po.id_user;

CREATE VIEW product_view AS
SELECT p.id as id,
       p.name as product_name,
       p.price as price,
       p.stock as stock,
       p.description as product_description,
       p.big_image_url as big_image_url,
       p.small_image_url as small_image_url,
       c.name as category_name,
       c.description as category_description,
       p.id_category as id_category,
       p.created_at as product_created_at,
       c.created_at as category_created_at,
       p.deleted as deleted
FROM product p INNER JOIN category c on c.id = p.id_category;

CREATE VIEW purchase_order_line_view AS
SELECT
    po.id as id,
    po.id_purchase_order as id_purchase_order,
    po.quantity as quantity,
    p.id as id_product,
    p.name as product_name,
    p.price as price,
    p.stock as stock,
    p.description as product_description,
    p.big_image_url as big_image_url,
    p.small_image_url as small_image_url,
    c.name as category_name,
    c.description as category_description,
    p.id_category as id_category,
    p.created_at as product_created_at,
    c.created_at as category_created_at,
    p.deleted as deleted
FROM purchase_order_line po INNER JOIN product p ON po.id_product = p.id INNER JOIN category c on c.id = p.id_category;