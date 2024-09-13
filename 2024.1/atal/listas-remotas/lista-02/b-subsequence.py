def longest_common_subsequence(s, t):
    m, n = len(s), len(t)

    # Cria a tabela dp com tamanho (m+1) x (n+1) inicializada com 0
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Preenche a tabela dp
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s[i - 1] == t[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    # Reconstrói a LCS a partir da tabela dp
    lcs = []
    i, j = m, n
    while i > 0 and j > 0:
        if s[i - 1] == t[j - 1]:
            lcs.append(s[i - 1])
            i -= 1
            j -= 1
        elif dp[i - 1][j] > dp[i][j - 1]:
            i -= 1
        else:
            j -= 1

    # A LCS foi construída de trás para frente, então invertemos antes de retornar
    return "".join(reversed(lcs))


# Leitura de dados
s = input().strip()
t = input().strip()

# Cálculo da LCS
resultado = longest_common_subsequence(s, t)

# Saída do resultado
print(resultado)
