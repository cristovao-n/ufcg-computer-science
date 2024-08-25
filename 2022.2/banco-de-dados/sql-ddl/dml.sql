-- question 3

-- it'll get the average for each fornecedor
-- if we don't use group by, we'd have n tuples of fornecedores, but just 1 average, resulting in an error
-- to fix that, we group by fornecedor, now we have an average for each fornecedor, matching the number of tuples
-- since we only want to return the groups where the average is less or equal than 163, we use having to filter and return only these groups.
SELECT fornecedor.NOME as nomeForcedor, AVG(produto.PRECO_COMPRA)
FROM fornecedor, fornecimento, produto
WHERE fornecedor.CODFORN = fornecimento.CODIGO_FORNECEDOR and produto.CODPROD = fornecimento.CODIGO_PRODUTO
GROUP BY fornecedor.NOME
HAVING AVG(produto.PRECO_COMPRA) <= 163


-- question 4

SELECT *
FROM produto
WHERE 
EXTRACT(YEAR FROM produto.DATA_FABRICACAO) = 2019 and 
produto.PRECO_VENDA >= 2000 and 
EXTRACT(YEAR FROM produto.DATA_VALIDADE) >= 2022

-- question 5

-- it only returns the name of the cliente which has the maximum amount of referrals
-- to fix that, we need to include the attributes of c1 in the select and in the group by statements of the inner query
-- there has to be a better way to do this
SELECT nome_cliente
FROM (
    SELECT c1.nome as nome_cliente, COUNT(*) as referrals
    FROM cliente c1, cliente c2
    WHERE c1.CODCLI = c2.CLIENTE_INDICA
    GROUP BY c1.nome, c2.CLIENTE_INDICA
    ORDER BY referrals DESC
)
WHERE ROWNUM = 1

-- question 10
-- we order by the biggest percentual difference between the buy_price and the sell_price
-- we then get the first row.

SELECT *
FROM (
    SELECT categoria.*
    FROM categoria, produto
    WHERE categoria.CODCAT = produto.COD_CATEGORIA
    ORDER BY produto.PRECO_COMPRA / produto.PRECO_VENDA ASC
)
WHERE ROWNUM = 1
