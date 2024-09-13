n = int(input())
platforms = list(map(int, input().split()))

cost = [float('inf')] * n
cost[0] = 0

for i in range(n):
    if i + 1 < n:
        cost[i + 1] = min(cost[i + 1], cost[i] + abs(platforms[i + 1] - platforms[i]))
    if i + 2 < n:
        cost[i + 2] = min(cost[i + 2], cost[i] + abs(platforms[i + 2] - platforms[i]))

print(cost[n - 1])
