lista1 = input().split()
lista2 = input().split()

for i in range(len(lista1)):
    if int(lista1[i]) == int(lista2[i]):
        lugar = i+1
        print(f"{lugar}: {lista1[i]}")
