package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length <= 1) {
			return;
		}

		Integer greatestElement = getGreatestElement(array);
		Integer smallestElement = getSmallestElement(array);

		Integer[] arrayCopy = Arrays.copyOf(array, array.length);
		Integer[] sumArray = createArrayFilledWith(0, greatestElement + 1 - smallestElement);

		for (int i = leftIndex; i <= rightIndex; i++) {
			sumArray[arrayCopy[i] - smallestElement] += 1;
		}

		for (int i = 1; i < sumArray.length; i++) {
			sumArray[i] = sumArray[i - 1] + sumArray[i];
		}

		for (int i = rightIndex; i >= leftIndex; i--) {
			Integer amountOfNumbersBefore = sumArray[arrayCopy[i] - smallestElement];
			array[amountOfNumbersBefore + leftIndex - 1] = arrayCopy[i];
			sumArray[arrayCopy[i] - smallestElement] -= 1;
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

	private static int getSmallestElement(Integer[] array) {
		Integer smallestElement = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(smallestElement) < 0) {
				smallestElement = array[i];
			}
		}

		return smallestElement;
	}

	private static Integer[] createArrayFilledWith(int numberToFill, int length) {
		Integer[] array = new Integer[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = numberToFill;
		}
		return array;
	}

}
