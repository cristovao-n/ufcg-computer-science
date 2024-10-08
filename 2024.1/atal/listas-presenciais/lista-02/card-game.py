def combinations(current, p1, p2, i, results):
    if i == len(current):
        results.append(current)
        return
    for p1_card in p1:
        if p1_card not in current:
            current[i] = p1_card
            i += 1
            combinations(current.copy(), p1, p2, i, results)

    for p2_card in p2:
        if p2_card not in current:
            current[i] = p2_card
            i += 1
            combinations(current.copy(), p1, p2, i, results)


test_cases = int(input())

for _ in range(test_cases):
    elements = list(map(int, input().split()))
    p1 = [elements[0], elements[1]]
    p2 = [elements[2], elements[3]]
    combinations = [
        [elements[0], elements[2], elements[1], elements[3]],
        [elements[0], elements[3], elements[1], elements[2]],
        [elements[1], elements[2], elements[0], elements[3]],
        [elements[1], elements[3], elements[0], elements[2]],
    ]
    count = 0
    for combination in combinations:
        p2_wins = combination[1] > combination[0] or combination[3] > combination[2]
        empate = combination[1] == combination[0] and combination[3] == combination[2]
        if not (p2_wins or empate):
            count += 1
    print(count)
