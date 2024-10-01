# Instalando biblioteca para realizar filtros
install.packages("dplyr")
library(dplyr)

# Importando dados
all_penguin <- read.csv("/caminho-absoluto-ate-o-arquivo/penguins_original.csv")

# ESTUDO SOBRE COMPRIMENTO BICO X PROFUNDIDADE BICO

# Definindo função para plot comprimento bico x profundidade bico
bill_length_vs_depth_plot <- function(penguins) {
    bill_length <- penguins$bill_length_mm
    bill_depth <- penguins$bill_depth_mm
    species <- penguins$species
    
    plot(bill_length, bill_depth, col=factor(species))
    legend("topright", legend=levels(factor(species)), col=factor(levels(factor(species))), pch=19)
}

# Realizando plot para todas as espécies em conjunto
bill_length_vs_depth_plot(all_penguin)

# Separando penguins por espécie
adelie_penguin <- all_penguin %>% filter(species == 'Adelie')
chinstrap_penguin <- all_penguin %>% filter(species == 'Chinstrap')
gentoo_penguin <- all_penguin %>% filter(species == 'Gentoo')

# Realizando plots para os penguins Adelie
bill_length_vs_depth_plot(adelie_penguin)

# Regressão Linear  para Adelie
lmAdelie = lm(bill_depth_mm~bill_length_mm, data = adelie_penguin)
summary(lmAdelie)

# Plot modelo linear
abline(lmAdelie)

# Realizando plots para os penguins Gentoo
bill_length_vs_depth_plot(gentoo_penguin)

# Regressão Linear para Gentoo
lmGentoo = lm(bill_depth_mm~bill_length_mm, data = gentoo_penguin)
summary(lmGentoo)

# Plot modelo linear
abline(lmGentoo)

# Realizando plots para os penguins Chinstrap
bill_length_vs_depth_plot(chinstrap_penguin)

# Regressão Linear  para Gentoo
lmChinstrap = lm(bill_depth_mm~bill_length_mm, data = chinstrap_penguin)
summary(lmChinstrap)

# Plot modelo linear
abline(lmChinstrap)

# ESTUDANDO SOBRE COMPRIMENTO ASA X MASSA CORPORAL

# Definindo função para plot comprimento asa x massa corporal
flipper_length_vs_body_mass <- function(penguins) {
    body_mass <- penguins$body_mass_g
    flipper_length <- penguins$flipper_length_mm
    
    plot(flipper_length, body_mass)
}

# Realizando plot
flipper_length_vs_body_mass(all_penguin)
# Regressão Linear
lmFlipperLengthBodyMass = lm(body_mass_g~flipper_length_mm, data = all_penguin)
summary(lmFlipperLengthBodyMass)
# Plot modelo linear
abline(lmFlipperLengthBodyMass)