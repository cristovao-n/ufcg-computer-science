def contar_inversoes(casas_finais):
    def merge_count_split_inv(arr, temp_arr, left, mid, right):
        i = left  # Inicial índice do subarray esquerdo
        j = mid + 1  # Inicial índice do subarray direito
        k = left  # Inicial índice do subarray temporário
        inv_count = 0

        while i <= mid and j <= right:
            if arr[i] <= arr[j]:
                temp_arr[k] = arr[i]
                i += 1
            else:
                temp_arr[k] = arr[j]
                inv_count += mid - i + 1
                j += 1
            k += 1

        while i <= mid:
            temp_arr[k] = arr[i]
            i += 1
            k += 1

        while j <= right:
            temp_arr[k] = arr[j]
            j += 1
            k += 1

        for i in range(left, right + 1):
            arr[i] = temp_arr[i]

        return inv_count

    def merge_sort_and_count(arr, temp_arr, left, right):
        inv_count = 0
        if left < right:
            mid = (left + right) // 2
            inv_count += merge_sort_and_count(arr, temp_arr, left, mid)
            inv_count += merge_sort_and_count(arr, temp_arr, mid + 1, right)
            inv_count += merge_count_split_inv(arr, temp_arr, left, mid, right)
        return inv_count

    temp_arr = [0] * len(casas_finais)
    return merge_sort_and_count(casas_finais, temp_arr, 0, len(casas_finais) - 1)


def resolver(casos_teste):
    resultados = []
    for n, pares in casos_teste:
        pares.sort()
        casas_finais = [b for _, b in pares]
        resultados.append(contar_inversoes(casas_finais))
    return resultados


def main():
    import sys

    input = sys.stdin.read
    dados = input().split()

    index = 0
    t = int(dados[index])
    index += 1
    casos_teste = []

    for _ in range(t):
        n = int(dados[index])
        index += 1
        pares = []
        for _ in range(n):
            a = int(dados[index])
            b = int(dados[index + 1])
            pares.append((a, b))
            index += 2
        casos_teste.append((n, pares))

    resultados = resolver(casos_teste)
    for resultado in resultados:
        print(resultado)


if _name_ == "_main_":
    main()
