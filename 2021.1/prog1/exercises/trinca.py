def trinca(digitos):
    for j in range(len(digitos)-1, -1, -1):
        base = digitos[j]
        for i in range(len(digitos)-1-j, -1, -1):
            if digitos[i]-base <= 2 and digitos[i]-base >= -2:
                digitos.pop(i)

digitos = [1, 2, 4, 5, 3]
trinca(digitos)
print(digitos)