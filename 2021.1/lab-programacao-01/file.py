from random import randint


def insert(array, index, value):
    for i in range(len(array) - 1, index, -1):
        array[i] = array[i - 1]
    array[index] = value


def pop(array, index=-1):
    if index != -1:
        for i in range(index, 9):
            array[i] = array[i + 1]
    else:
        for i in range(1, len(array)):
            if array[i] is None:
                array[i - 1] = None
                return
        array[len(array) - 1] = None


def main():
    # length = int(input())
    length = 10
    array = [None]*length

    for i in range(length):
        array[i] = randint(0, 9)

    print(array)
    pop(array)
    pop(array)
    pop(array)
    print(array)


if __name__ == "__main__":
    main()
