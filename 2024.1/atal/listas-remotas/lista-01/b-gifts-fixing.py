test_cases = int(input())

for _ in range(test_cases):
    gifts = int(input())
    candies = list(map(int, input().split()))
    oranges = list(map(int, input().split()))

    min_candy = min(candies)
    min_orange = min(oranges)

    count = 0
    for i in range(gifts):
        while candies[i] > min_candy and oranges[i] > min_orange:
            candies[i] = candies[i] - 1
            oranges[i] = oranges[i] - 1
            count += 1
        while candies[i] > min_candy:
            count += 1
        while oranges[i] > min_orange:
            count += 1
    print(count)
