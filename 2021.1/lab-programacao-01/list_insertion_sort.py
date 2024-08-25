def insertion_sort(array, num):
    for i in range(len(array)):
        if num <= array[i]:
            array.insert(i, num)
            return
    array.append(num)


array = []
while True:
    line = input()
    if not line:
        break
    number = int(line)
    insertion_sort(array, number)
    print(array)
