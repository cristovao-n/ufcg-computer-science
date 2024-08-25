CREATE TRIGGER Check_stock
AFTER UPDATE ON Produto
FOR EACH ROW
WHEN (new.estoque < 5)
BEGIN
  INSERT INTO Compra VALUES (new.idProduto, 50)
END


CREATE VIEW DinheiroPorCategoria
AS
SELECT p.categoria, sum(p.preco)
FROM Produto p
GROUP BY p.categoria
HAVING sum(p.preco) > 3000





