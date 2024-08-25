def insert(array, index, value):
    for i in range(len(array) - 1, index, -1):
        array[i] = array[i - 1]
    array[index] = value


def insertion_sort(array, num):
    for i in range(len(array)):
        assert array[len(array) - 1] is None, "array is full"
        if array[i] is None:
            array[i] = num
            return
        if num <= array[i]:
            insert(array, i, num)
            return


array = [None] * 10
while True:
    line = input()
    if not line:
        break
    number = int(line)
    insertion_sort(array, number)
    print(array)
