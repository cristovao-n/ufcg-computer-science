alphabet = "abcdefghijklmnopqrstuvwxyz"

test_cases = int(input())


def get_different_char(char):
    for alphabet_char in alphabet:
        if alphabet_char != char:
            return alphabet_char
    return ""


for _ in range(test_cases):
    password = input()
    answer = ""
    added = False
    for i in range(len(password) - 1):
        answer += password[i]
        if password[i] == password[i + 1] and added is False:
            added = True
            answer += get_different_char(password[i])
    answer += password[-1]
    if added is False:
        answer += get_different_char(password[-1])

    print(answer)
