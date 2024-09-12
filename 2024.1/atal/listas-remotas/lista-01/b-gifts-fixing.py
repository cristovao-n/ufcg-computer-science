test_cases = int(input())

for _ in range(test_cases):
    gifts = int(input())
    candies = list(map(int, input().split()))
    oranges = list(map(int, input().split()))

    min_candy = min(candies)
    min_orange = min(oranges)

    count = 0
    for i in range(gifts):
        move_candies = candies[i] - min_candy
        move_oranges = oranges[i] - min_orange
        
        count += max(move_candies, move_oranges)
    
    print(count)
