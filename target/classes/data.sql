--ALTER TABLE tb_category add FOREIGN KEY(product_id) REFERENCES tb_product(product_id);
--
--ALTER TABLE tb_product add FOREIGN KEY(category_id) REFERENCES tb_category(category_id);

INSERT INTO tb_category(name) VALUES('Roupa');

INSERT INTO tb_product(name, price, category_id) VALUES('Camisa', 10.00, 1);

INSERT INTO tb_state(name) VALUES ('São Paulo');
INSERT INTO tb_state(name) VALUES ('Minas Gerais');

INSERT INTO tb_city(name, state_id) VALUES ('Uberlândia', 2);
INSERT INTO tb_city(name, state_id) VALUES ('São Paulo', 1);
INSERT INTO tb_city(name, state_id) VALUES ('Campinas', 1);


