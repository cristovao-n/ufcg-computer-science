import bisect


n = int(input())
pieces = list(map(int, input().split()))

columns = []

for piece in pieces:
    pos = bisect.bisect_right(columns, piece)
    if pos < len(columns):
        columns[pos] = piece
    else:
        columns.append(piece)

print(len(columns))
