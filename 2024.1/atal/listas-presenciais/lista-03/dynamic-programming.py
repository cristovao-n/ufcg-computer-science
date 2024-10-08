# This algorithm calculates the minimum cost of platform jumps. The jump size is variable.

line = input().split()

for i in range(len(line)):
    line[i] = int(line[i])

n = line[0]
k = line[1]


alturas = input().split()

for i in range(len(alturas)):
    alturas[i] = int(alturas[i])


cost = [0] * (n)
cost[0] = 0

for i in range(1, n):
    options = [float("inf")] * k
    for j in range(1, k + 1):
        if i - j >= 0:
            options[j - 1] = cost[i - j] + abs(alturas[i - j] - alturas[i])
    cost[i] = min(options)

print(cost[-1])
