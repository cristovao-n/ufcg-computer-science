import heapq


def get_path(end, parents):
    path = []
    current = end
    while parents[current] is not None and current in parents:
        path.append(current)
        current = parents[current]

    if current == 1:
        path.append(1)
        path.reverse()
        return path
    return ["-1"]


n, m = map(int, input().split())
graph = {i: [] for i in range(1, n + 1)}


def dijkstra(graph, start):
    distances = {node: float("inf") for node in graph}
    parent = {node: None for node in graph}

    distances[start] = 0
    queue = [(0, start)]

    while queue:
        current_distance, current_node = heapq.heappop(queue)

        if current_distance > distances[current_node]:
            continue

        for next_node, weight in graph[current_node]:
            distance_temp = current_distance + weight
            if distance_temp < distances[next_node]:
                distances[next_node] = distance_temp
                parent[next_node] = current_node
                heapq.heappush(queue, (distance_temp, next_node))

    return distances, parent


for i in range(m):
    vertice1, vertice2, peso = map(int, input().split())

    graph[vertice1].append((vertice2, peso))
    graph[vertice2].append((vertice1, peso))

_, parents = dijkstra(graph, 1)

path = get_path(n, parents)

print(" ".join(map(str, path)))
