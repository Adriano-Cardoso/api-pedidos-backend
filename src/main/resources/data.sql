--ALTER TABLE tb_category add FOREIGN KEY(product_id) REFERENCES tb_product(product_id);
--
--ALTER TABLE tb_product add FOREIGN KEY(category_id) REFERENCES tb_category(category_id);

INSERT INTO tb_category(name) VALUES('Informatica');
INSERT INTO tb_category(name) VALUES('Games');

INSERT INTO tb_product(name, price, category_id) VALUES('Monitor Dell', 950.00, 1);
INSERT INTO tb_product(name, price, category_id) VALUES('Teclado Mecanico', 340.00, 2);



INSERT INTO tb_state(name) VALUES ('São Paulo');
INSERT INTO tb_state(name) VALUES ('Recife');

INSERT INTO tb_city(name, state_id) VALUES ('Recife', 2);
INSERT INTO tb_city(name, state_id) VALUES ('São Paulo', 1);
INSERT INTO tb_city(name, state_id) VALUES ('Campinas', 1);


--inserindo cliente
INSERT INTO tb_client(address_id, cpf_ou_cnpj, email, name, type_client) VALUES (1, '12312345671', 'tonystark@email.com', 'Tony Stark', 2);
INSERT INTO tb_client(address_id, cpf_ou_cnpj, email, name, type_client) VALUES (2, '12312345672', 'piterparker@email.com', 'Piter Parker', 1);
INSERT INTO tb_client(address_id, cpf_ou_cnpj, email, name, type_client) VALUES (3, '12312345673', 'brucewayne@email.com', 'Bruce Wayne', 2);
INSERT INTO tb_client(address_id, cpf_ou_cnpj, email, name, type_client) VALUES (4, '12312345674', 'alfredpenilorf@email.com', 'Alfred Penilorf', 1);
INSERT INTO tb_client(address_id, cpf_ou_cnpj, email, name, type_client) VALUES (5, '12312345675', 'geraldderivia@email.com', 'Gerald de Rivia', 2);
INSERT INTO tb_client(address_id, cpf_ou_cnpj, email, name, type_client) VALUES (6, '12312345676', 'kratos@email.com', 'Kratos', 1);

-- Inserindo endereço
INSERT INTO tb_address(bairro, cep, complemento, logradouro, number, city_id, client_id) VALUES ('Avenida Boa viagem','345930223', 'Apto 303', 'Praça', '300', 1, 1);
INSERT INTO tb_address(bairro, cep, complemento, logradouro, number, city_id, client_id) VALUES ('Rua professor luiz a gondin', '345930224', 'Próximo ao colégio carla patricia', 'Rua', '116', 1, 2);
INSERT INTO tb_address(bairro, cep, complemento, logradouro, number, city_id, client_id) VALUES ('Alphaville','345930225', 'Casa 10', 'Jardim', '10', 2, 3);
INSERT INTO tb_address(bairro, cep, complemento, logradouro, number, city_id, client_id) VALUES ('Alphaville','345930226', 'Casa 10', 'Jardim', '10', 2, 4);
INSERT INTO tb_address(bairro, cep, complemento, logradouro, number, city_id, client_id) VALUES ('Rua do vale','345930227', 'Casa 303', 'Jardim', '303', 3, 5);
INSERT INTO tb_address(bairro, cep, complemento, logradouro, number, city_id, client_id) VALUES ('Ahphenhein','345930228', 'Casa 30', 'Jardim', '30', 3, 6);


INSERT INTO tb_phone(client_client_id, phones) values (1, '81 988889990');
INSERT INTO tb_phone(client_client_id, phones) values (2, '81 988889991');
INSERT INTO tb_phone(client_client_id, phones) values (3, '11 988889992');
INSERT INTO tb_phone(client_client_id, phones) values (4, '81 988889993');
INSERT INTO tb_phone(client_client_id, phones) values (5, '81 988889994');
INSERT INTO tb_phone(client_client_id, phones) values (6, '81 9888899995');