data <- read.csv("/caminho-absoluto-ate-o-arquivo/penguin.csv")

get_t_critico <- function(p, graus_liberdade) {
  # valor hardcoded simulando uma consulta à tabela t-student
  return(1.699)
}

get_qui_quadrado_critico <- function(p, liberdade) {
  return (42.557)
}

massa_corporal <- data$massa_corporal_g
media <- mean(massa_corporal)
variancia <- var(massa_corporal)
desvio_padrao <- sqrt(variancia)

# testes a um nível de 5%
nivel_significancia <- 0.05

# =====================================================================================

# TESTE PARA MÉDIA COM VARIÂNCIA DESCONHECIDA
# t-student com n-1 graus de liberdade

# hipotese: média populacional da massa corporal maior ou igual a 4500 gramas
media_populacional_teste <- 4500


# teste unilateral: p = 2*nivel_significancia
t_critico <- get_t_critico(2*nivel_significancia, 29)

t_observado <- (media - media_populacional_teste) / (desvio_padrao / sqrt(30))

# Se t_observado <= -t_critico, rejeitamos Ho.

# t_observado não é menor ou igual a -t_critico.
print(t_observado <= t_critico * (-1))
# Aceitamos Ho: há evidências de que a média populacional seja maior ou igual a 4500g a um nível de 5%.

# =====================================================================================

# TESTE PARA VARIÂNCIA

# hipotese: variância populacional maior ou igual a 400000
variancia_teste <- 600000

qui_quadrado_critico <- get_qui_quadrado_critico(1-nivel_significancia, 29)

qui_quadrado_observado <- (29*variancia)/variancia_teste

# Se qui_quadrado_observado <= qui_quadrado_critico, rejeitamos Ho.

# qui_quadrado_observado é menor ou igual a qui_quadrado_critico.
print(qui_quadrado_observado <= qui_quadrado_critico)
# Rejeitamos Ho: não há evidências de que a variância populacional seja maior ou igual a 600.000 a um nível de 5%.





