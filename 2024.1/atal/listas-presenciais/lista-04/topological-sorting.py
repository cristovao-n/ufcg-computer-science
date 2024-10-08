# This algorithm performs a topological sorting. 
# It hasn't passed all case tests (15/17)

import sys

sys.setrecursionlimit(10000)


def dfs_order(graph, start, visited):
    order = []
    visited.add(start)
    for adj in graph[start]:
        if adj not in visited:
            order += dfs_order(graph, adj, visited)
    return order + [start]


def topological_sorting(graph, start=None):
    visited = set()
    order = []
    if start:
        order += dfs_order(graph, start, visited)
    for vertex in graph.keys():
        if vertex not in visited:
            order += dfs_order(graph, vertex, visited)
    return order[::-1]


graph = {}

first_line = list(map(int, input().split()))
missions = first_line[0]
pre_requisites = first_line[1]


visited = [False] * missions

for i in range(missions):
    graph[i + 1] = []

entrypoint = -1
for i in range(pre_requisites):
    line = list(map(int, input().split()))
    graph[line[0]].append(line[1])
    if i == 0:
        entrypoint = line[0]


def visit(graph, visited, entrypoint):
    visited[entrypoint - 1] = True
    for connection in graph[entrypoint]:
        if visited[connection - 1]:
            print("IMPOSSIBLE")
            exit()
        visit(graph, visited, connection)
    visited[entrypoint - 1] = False


if entrypoint != -1:
    visit(graph, visited, entrypoint)
result = topological_sorting(graph)

print(*result)
