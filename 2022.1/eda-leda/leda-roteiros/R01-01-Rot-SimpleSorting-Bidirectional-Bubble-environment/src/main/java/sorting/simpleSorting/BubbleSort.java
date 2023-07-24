package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			boolean atLeastOneSwapOccured = false;
			for (int j = leftIndex; j < leftIndex + rightIndex - i; j++) {
				boolean isCurrentElementGreaterThanNextElement = array[j].compareTo(array[j+1]) > 0;
				if (isCurrentElementGreaterThanNextElement) {
					Util.swap(array, j, j+1);
					atLeastOneSwapOccured = true;
				}
			}
			if (!atLeastOneSwapOccured) {
				break;
			}
		}
	}

}
