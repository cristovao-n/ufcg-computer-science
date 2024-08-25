package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			int smallestElementIndex = this.getSmallestElementIndex(array, i, rightIndex);
			Util.swap(array, smallestElementIndex, i);
		}
	}

	private int getSmallestElementIndex(T[] array, int leftIndex, int rightIndex) {
		int smallestIndex = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(array[smallestIndex]) < 0) {
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
}
