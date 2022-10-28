--ALTER TABLE tb_category add FOREIGN KEY(product_id) REFERENCES tb_product(product_id);
--
--ALTER TABLE tb_product add FOREIGN KEY(category_id) REFERENCES tb_category(category_id);

INSERT INTO tb_category(category_id, name) VALUES(1,'Roupa');

INSERT INTO tb_product(product_id, name, price, category_id) VALUES(1,'Camisa', 10.00, 1);
