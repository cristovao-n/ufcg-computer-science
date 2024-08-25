package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || array.length <= 1) {
			return;
		}

		int middleIndex = (leftIndex + rightIndex) / 2;
		this.sort(array, leftIndex, middleIndex);
		this.sort(array, middleIndex + 1, rightIndex);
		this.merge(array, leftIndex, middleIndex, rightIndex);

	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		T[] baseArray = Arrays.copyOf(array, array.length);

		int i = leftIndex;
		int j = middleIndex + 1;
		int k = leftIndex;

		while (i <= middleIndex && j <= rightIndex) {
			if (baseArray[i].compareTo(baseArray[j]) <= 0) {
				array[k] = baseArray[i];
				i++;
			} else {
				array[k] = baseArray[j];
				j++;
			}
			k++;
		}

		while (i <= middleIndex) {
			array[k] = baseArray[i];
			i++;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = baseArray[j];
			j++;
			k++;
		}

	}
}
