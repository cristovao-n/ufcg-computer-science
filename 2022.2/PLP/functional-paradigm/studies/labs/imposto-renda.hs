import Text.Printf

main:: IO()
main = do
    salario <- readLn :: IO Float
    let impostoPago = calcularImposto salario
    let text1 = "O valor do imposto de renda retido eh: R$"
    let text2 = "O salario liquido eh: R$"
    printf "%s %.2f\n" text1 impostoPago
    printf "%s $%.2f\n" text2 (salario - impostoPago)

calcularImposto:: Float -> Float
calcularImposto salario
    | salario <= 1903.98 = 0
    | salario <= 2826.65 = 142.80 + (salario - 1903.99) * 0.075
    | salario <= 3751.05 = 354.80 + (salario - 2826.66) * 0.15
    | salario <= 4664.68 = 636.13 + (salario - 3751.06) * 0.225
    | otherwise = 869.36 + (salario - 4664.68) * 0.275
