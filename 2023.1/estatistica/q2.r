data <- read.csv("/caminho-absoluto-ate-o-arquivo/penguin.csv")

comprimento_bico <- data$comprimento_bico_mm
massa_corporal <- data$massa_corporal_g

#estimadores pontuais
#massa corporal
media_am_massa <- mean(massa_corporal) 
dp_am_massa <- sd(massa_corporal)

#comprimento do bico
media_am_bico <- mean(comprimento_bico)
dp_am_bico <- sd(comprimento_bico)

#estimadores intervalares
#considerando intervalo de confiança 95%
nc <- 0.95
#Considerando Comprimento do bico e Massa corporal
#Estimação intervalar da média
v_critico_massa <- qt((1+nc)/2, df = length(data$massa_corporal_g)-1) #df: graus de liberdade
erro_padrao_massa <- dp_am_massa/sqrt(length(data$massa_corporal_g))
lim_inf_massa <- media_am_massa - v_critico_massa*erro_padrao_massa
lim_sup_massa <- media_am_massa + v_critico_massa*erro_padrao_massa

v_critico_bico <- qt((1+nc)/2, df = length(data$comprimento_bico_mm)-1) #df: graus de liberdade
erro_padrao_bico <- dp_am_bico/sqrt(length(data$comprimento_bico_mm))
lim_inf_bico <- media_am_bico - v_critico_bico*erro_padrao_bico
lim_sup_bico <- media_am_bico + v_critico_bico*erro_padrao_bico

cat("Intervalo de confiança da variância populacional da massa corporal (", nc * 100, "%): [", lim_inf_massa, ", ", lim_sup_massa, "]\n")
cat("Intervalo de confiança da variância populacional do comprimento do bico (", nc * 100, "%): [", lim_inf_bico, ", ", lim_sup_bico, "]\n")
#limites inferiores e superiores indicam intervalo com confiança de 95%
#sobre estimação do valor da média da população

#Estimação intervalar da Variância
#Considerando o mesmo nivel de confiança 95%
n <- length(data$massa_corporal_g)
gl <- n-1 # graus de liberdade
var_am_massa <- var(data$massa_corporal_g)
var_am_bico <- var(data$comprimento_bico_mm)

#valores criticos
v_crit_sup <- qchisq(p = nc+0.025, df = gl)
cat(v_crit_sup)
v_crit_inf <- qchisq(p = 0.025, df = gl)
cat(v_crit_inf)

#valores limites
lim_var_sup_massa <- (gl*var_am_massa)/v_crit_inf
lim_var_inf_massa <- (gl*var_am_massa)/v_crit_sup

lim_var_sup_bico <- (gl*var_am_bico)/v_crit_inf
lim_var_inf_bico <- (gl*var_am_bico)/v_crit_sup

cat("Intervalo de confiança da variância populacional da massa corporal (", nc * 100, "%): [", lim_var_inf_massa, ", ", lim_var_sup_massa, "]\n")
cat("Intervalo de confiança da variância populacional do comprimento do bico (", nc * 100, "%): [", lim_var_inf_bico, ", ", lim_var_sup_bico, "]\n")

