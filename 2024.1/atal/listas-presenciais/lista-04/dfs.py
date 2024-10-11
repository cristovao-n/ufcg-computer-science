# This algorithm finds the maximum height of a graph

import sys

sys.setrecursionlimit(3000)


def dfs_visit(vertex, graph, colors, parents, discovery_time, finish_time, deep):
    colors[vertex] = "GRAY"
    discovery_time[0] += 1
    finish_time[vertex] = None
    returned_deep = 0
    for adj in graph[vertex]:
        if colors[adj] == "WHITE":
            parents[adj] = vertex
            returned_deep = max(
                returned_deep,
                dfs_visit(
                    adj, graph, colors, parents, discovery_time, finish_time, deep + 1
                ),
            )
    colors[vertex] = "BLACK"
    discovery_time[0] += 1
    finish_time[vertex] = discovery_time[0]
    return max(returned_deep, deep)


def dfs(graph, start):
    vertices = list(graph.keys())
    colors = {}
    parent = {}
    discovery_time = [0]
    finish_time = {}

    for vertex in vertices:
        colors[vertex] = "WHITE"
        parent[vertex] = None

    deep = dfs_visit(start, graph, colors, parent, discovery_time, finish_time, 1)

    return deep


graph = {}

alunos = int(input())

relacao = []

for i in range(alunos):
    graph[i + 1] = []
    relacao.append(int(input()))

mentores = []

for i in range(len(relacao)):
    if relacao[i] == -1:
        mentores.append(i + 1)
    else:
        graph[i + 1].append(relacao[i])
        graph[relacao[i]].append(i + 1)

profundidade_maxima = 1

for mentor in mentores:
    profundidade_maxima = max(profundidade_maxima, dfs(graph, mentor))

print(profundidade_maxima)
