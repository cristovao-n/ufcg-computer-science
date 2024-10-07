import heapq

def prim(n, graph):
    used_edges = 0
    total = 0
    visited = set()
    heap = [(0, 1)]

    while heap and used_edges < n:
        cost, city = heapq.heappop(heap)
        
        if city not in visited:
            visited.add(city)
            total += cost
            used_edges += 1

            for adj_city, repair_cost in graph[city]:
                if adj_city not in visited:
                    heapq.heappush(heap, (repair_cost, adj_city))

    if used_edges == n:
        return total
    return "IMPOSSIBLE"

n, m = map(int, input().split())
graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

print(prim(n, graph))
