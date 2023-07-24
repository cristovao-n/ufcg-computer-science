package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int countOrderedLeft = 0;
		int countOrderedRight = 0;
		for (int i = 0; i < rightIndex; i++) {
			boolean rightSwapOccured = false;
			boolean leftSwapOccured = false;
			if (i % 2 == 0) {
				rightSwapOccured = this.moveToTheRight(array, leftIndex + countOrderedLeft, rightIndex - countOrderedRight);
				countOrderedRight++;
			} else {
				leftSwapOccured = this.moveToTheLeft(array, leftIndex + countOrderedLeft, rightIndex - countOrderedRight);
				countOrderedLeft++;
			}

			if (!rightSwapOccured && !leftSwapOccured) {
				break;
			}

		}
	}

	private boolean moveToTheRight(T[] array, int leftIndex, int rightIndex) {
		boolean atLeastOneSwapOccured = false;
		for (int i = leftIndex; i < rightIndex; i++) {
			boolean isCurrentGreaterThanNext = array[i].compareTo(array[i + 1]) > 0;
			if (isCurrentGreaterThanNext) {
				Util.swap(array, i, i + 1);
				atLeastOneSwapOccured = true;
			}
		}

		return atLeastOneSwapOccured;
	}

	private boolean moveToTheLeft(T[] array, int leftIndex, int rightIndex) {
		boolean atLeastOneSwapOccured = false;
		for (int i = rightIndex; i > leftIndex; i--) {
			boolean isCurrentSmallerThanPrevious = array[i].compareTo(array[i - 1]) < 0;
			if (isCurrentSmallerThanPrevious) {
				Util.swap(array, i, i - 1);
				atLeastOneSwapOccured = true;
			}
		}

		return atLeastOneSwapOccured;
	}

}
