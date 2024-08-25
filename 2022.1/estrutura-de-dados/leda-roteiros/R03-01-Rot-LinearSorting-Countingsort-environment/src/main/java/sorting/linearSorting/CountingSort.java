package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length <= 1) {
			return;
		}

		Integer greatestElement = getGreatestElement(array);
		Integer[] arrayCopy = Arrays.copyOf(array, array.length);
		Integer[] sumArray = createArrayFilledWith(0, greatestElement + 1);

		for (int i = leftIndex; i <= rightIndex; i++) {
			sumArray[arrayCopy[i]] += 1;
		}

		for (int i = 1; i < sumArray.length; i++) {
			sumArray[i] = sumArray[i - 1] + sumArray[i];
		}

		for (int i = rightIndex; i >= leftIndex; i--) {
			Integer amountOfNumbersBefore = sumArray[arrayCopy[i]];
			array[amountOfNumbersBefore + leftIndex - 1] = arrayCopy[i];
			sumArray[arrayCopy[i]] -= 1;
		}

	}

	private static int getGreatestElement(Integer[] array) {
		Integer greatestElement = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(greatestElement) > 0) {
				greatestElement = array[i];
			}
		}

		return greatestElement;

	}

	private static Integer[] createArrayFilledWith(int numberToFill, int length) {
		Integer[] array = new Integer[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = numberToFill;
		}
		return array;
	}

}
