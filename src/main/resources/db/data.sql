INSERT INTO produtos(preco_unitario, qtd_atual, qtd_max, qtd_min, descricao)
    VALUES(1000.0, 25, 30, 5, 'Geladeira frost-free 220V');
INSERT INTO produtos(preco_unitario, qtd_atual, qtd_max, qtd_min, descricao)
    VALUES(100.0, 65, 100, 30, 'Secador de cabelo 110V');

INSERT INTO clientes(nome) VALUES ('Thanos');
INSERT INTO clientes(nome) VALUES ('Blip');

INSERT INTO pedidos(cliente_id) VALUES (1);
INSERT INTO pedidos(cliente_id) VALUES (2);

INSERT INTO itens_pedido(quantidade, pedido_id, produto_id)
    VALUES(2, 1, 1);
INSERT INTO itens_pedido(quantidade, pedido_id, produto_id)
    VALUES(5, 2, 1);
INSERT INTO itens_pedido(quantidade, pedido_id, produto_id)
    VALUES(66, 2, 2);

INSERT INTO orcamentos(aprovado, percentual_desconto_aplicado, percentual_imposto_aplicado, data, pedido_id)
    VALUES (FALSE, 0.05, 0.1, TIMESTAMP '2023-11-12 12:00:00', 1);
INSERT INTO orcamentos(aprovado, percentual_desconto_aplicado, percentual_imposto_aplicado, data, pedido_id)
    VALUES (FALSE, 0.05, 0.1, TIMESTAMP '2023-11-12 12:00:00', 2);