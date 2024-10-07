data <- read.csv("/caminho-absoluto-ate-o-arquivo/penguin.csv")

# declaração da função que calcula a moda
calcular_moda <- function(column) {
  counts <- table(column)
  mode_value <- names(counts[counts == max(counts)])
  return(mode_value)
}

# atribuição de variáveis para comprimento do bico e massa corporal do pinguin
comprimento_bico <- data$comprimento_bico_mm
massa_corporal <- data$massa_corporal_g

# cálculo das grandezas pedidas na questão
media <- mean(comprimento_bico)
mediana <- median(comprimento_bico)
moda <- calcular_moda(comprimento_bico)
variancia <- var(comprimento_bico)
desvio_padrao <- sqrt(variancia)
coeficiente_correlacao <- cor(comprimento_bico, massa_corporal)

# Valor que representa o ponto de equilíbrio dos dados
print(paste("Média: ", media))

# Valor que divide o conjunto de dados em duas metades iguais
print(paste("Mediana: ", mediana))

# Tamanho de bico que mais se repete
print(paste("Moda: ", moda))

# Valor que mede o grau de dispersão dos dados em torno da média
print(paste("Variância: ", variancia))

# Avalia a dispersão dos valores em relação à média
print(paste("Desvio padrão: ", desvio_padrao))

# Como o coeficiente de correlação é maior que zero, temos que há correlação entre as duas variáveis
# Ou seja, o comprimento de bico aumenta conforme a massa corporal
print(paste("Coeficiente de correlação: ", coeficiente_correlacao))

# Histograma que separa em 7 classes de massa corporal, cada classe com 500g
hist(massa_corporal, breaks = 5, main = "Massa corporal", xlab = "Massa (g)", ylab = "Frequência", col = "lightblue")

# Boxplot que mostra a dispersão dos dados de massa corporal dos pinguins
boxplot(massa_corporal, main="Massa corporal", horizontal = TRUE, xlab="Massa (g)", col="lightblue")

# Gráfico de dispersão que relaciona o comprimento do bixo com a massa corporal dos pinguins
# evidenciando que, conforme o comprimento de bico aumenta, a massa também
plot(comprimento_bico, massa_corporal, main="Gráfico de Dispersão", xlab="Comprimento do bico", ylab="Massa corporal", col="lightblue", pch=19)
