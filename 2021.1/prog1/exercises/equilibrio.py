pares = []
impares = []
motivo_break = ''
while True:
  numero = int(input())
  if numero%2 == 0:
    pares.append(numero)
  else:
    impares.append(numero)
  if len(pares) - len(impares) > 2:
    motivo_break = 'PARES'
    break
  if len(impares) - len(pares) > 2:
    motivo_break = 'IMPARES'
    break

print(f"{motivo_break} em maior quantidade")
print("PARES:")
for e in pares:
  print(e)
print("IMPARES:")
for e in impares:
  print(e)