def get_heights(permutation, start, end, heights, height):
    max_index = start
    for i in range(start, end):
        if permutation[i] > permutation[max_index]:
            max_index = i
    heights[max_index] = height
    if start < max_index:
        get_heights(permutation, start, max_index, heights, height + 1)
    if max_index + 1 < end:
        get_heights(permutation, max_index + 1, end, heights, height + 1)


case_tests = int(input())

for _ in range(case_tests):
    length = int(input())
    permutation = list(map(int, input().split()))
    heights = [0] * length
    get_heights(permutation, 0, length, heights, 0)
    result = ""
    print(" ".join(map(str, heights)))
