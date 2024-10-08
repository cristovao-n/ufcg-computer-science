elements = list(map(int, input().split()))
n = elements[0]
m = elements[1]

quebra_cabecas = list(map(int, input().split()))
quebra_cabecas.sort()

melhor_solucao = quebra_cabecas[n - 1] - quebra_cabecas[0]
for i in range(m - n + 1):
    possivel_solucao = quebra_cabecas[n - 1 + i] - quebra_cabecas[i]
    if possivel_solucao < melhor_solucao:
        melhor_solucao = possivel_solucao

print(melhor_solucao)
