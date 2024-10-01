# Lê os dados do arquivo CSV.
data <- read.csv("/caminho-absoluto-ate-o-arquivo/penguin.csv")

# Cria conjuntos diferentes para cada variável numérica.
com_bic <- data$comprimento_bico_mm
prf_bic <- data$profundidade_bico_mm
tam_asa <- data$tamanho_asa_mm
mas_cor <- data$massa_corporal_g

# Define uma semente para gerar números aleatórios.
set.seed(321)

# Adiciona opcionalmente uma pequena quantidade de ruído nos conjuntos de dados gerados anteriormente, para remover os empates (valores repetidos em mais de um dado). O teste Kolmogorov-Smirnov é mais apropriado para dados sem empate. 
com_bic <- com_bic + runif(length(com_bic)) * 1e-10
prf_bic <- prf_bic + runif(length(prf_bic)) * 1e-10
tam_asa <- tam_asa + runif(length(tam_asa)) * 1e-10
mas_cor <- mas_cor + runif(length(mas_cor)) * 1e-10

print("Teste Kolmogorov-Smirnov com as seguintes variaveis: 1) Comprimento do bico 2) Profundidade do bico 3) Tamanho da asa 4) Massa corporal")

# Realizamos o teste para cada um dos conjuntos de dados numéricos.
result_com_bic <- ks.test(com_bic, "pnorm", mean = mean(com_bic), sd = sd(com_bic))
result_prf_bic <- ks.test(prf_bic, "pnorm", mean = mean(prf_bic), sd = sd(prf_bic))
result_tam_asa <- ks.test(tam_asa, "pnorm", mean = mean(tam_asa), sd = sd(tam_asa))
result_mas_cor <- ks.test(mas_cor, "pnorm", mean = mean(mas_cor), sd = sd(mas_cor))

# Para cada conjunto de dados que foi testado, mostra sua estatística e seu valor-p.
print("Resultados do teste na variavel 1: ")
print(paste("   Estatistica: ", result_com_bic$statistic))
print(paste("   Valor-p: ", result_com_bic$p.value))

print("Resultados do teste na variavel 2: ")
print(paste("   Estatistica: ", result_prf_bic$statistic))
print(paste("   Valor-p: ", result_prf_bic$p.value))

print("Resultados do teste na variavel 3: ")
print(paste("   Estatistica: ", result_tam_asa$statistic))
print(paste("   Valor-p: ", result_tam_asa$p.value))

print("Resultados do teste na variavel 4: ")
print(paste("   Estatistica: ", result_mas_cor$statistic))
print(paste("   Valor-p: ", result_mas_cor$p.value))

# Cria uma variável para guardar a média dos conjuntos de dados originais. 
original_stats <- c(mean(data$comprimento_bico_mm), mean(data$profundidade_bico_mm), mean(data$tamanho_asa_mm), mean(data$massa_corporal_g))

# Cria uma variável para guardar as estatísticas do teste Kolmogorov-Smirnov, executado em cada conjunto dos dados originais. 
result_stats <- c(result_com_bic$statistic, result_prf_bic$statistic, result_tam_asa$statistic, result_mas_cor$statistic)

# Calcula a correlação entre a estatística do teste Kolmogorov-Smirnov de um conjunto de dados e sua média.
correlation <- cor(result_stats, original_stats)

# Mostra a correlação entre as médias dos conjuntos de dados originais e as estatísticas do teste Kolmogorov-Smirnov, executado em cada conjunto.
print(paste("Correlacao entre estatisticas do teste Kolmogorov-Smirnov e as variáveis originais dos dados: ", correlation))
