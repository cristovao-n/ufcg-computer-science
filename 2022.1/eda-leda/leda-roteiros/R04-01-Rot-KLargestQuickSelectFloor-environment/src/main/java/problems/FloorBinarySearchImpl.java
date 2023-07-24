package problems;

import java.util.Arrays;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		this.sort(array, 0, array.length - 1);
		return this.getFloor(array, x);

	}

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || array.length <= 1) {
			return;
		}

		int pivotIndex = partition(array, leftIndex, rightIndex);

		this.sort(array, leftIndex, pivotIndex - 1);
		this.sort(array, pivotIndex + 1, rightIndex);

	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int medianPivotIndex = this.pickPivotIndex(array, leftIndex, rightIndex);
		Util.swap(array, leftIndex, medianPivotIndex);
		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i += 1;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex, i);
		return i;

	}

	private int pickPivotIndex(Integer[] array, int leftIndex, int rightIndex) {
		int middleIndex = (leftIndex + rightIndex) / 2;
		Integer[] sorted = Arrays.copyOf(array, 3);
		sorted[0] = array[leftIndex];
		sorted[1] = array[middleIndex];
		sorted[2] = array[rightIndex];
		Arrays.sort(sorted);

		if (sorted[1].compareTo(array[leftIndex]) == 0) {
			return leftIndex;
		}

		if (sorted[1].compareTo(array[middleIndex]) == 0) {
			return middleIndex;
		}
		return rightIndex;

	}

	public Integer getFloor(Integer[] array, Integer number) {
		return this.getFloor(array, 0, array.length - 1, number, null);
	}

	private Integer getFloor(Integer[] array, int leftIndex, int rightIndex, Integer number, Integer floor) {
		if (leftIndex > rightIndex) {
			return floor;
		}

		int middle = (leftIndex + rightIndex) / 2;

		if (number.compareTo(array[middle]) == 0) {
			return number;
		}

		if (number.compareTo(array[middle]) < 0) {
			return this.getFloor(array, leftIndex, middle - 1, number, floor);
		} else {
			return this.getFloor(array, middle + 1, rightIndex, number, array[middle]);
		}

	}

	/*
	 * Binary search algorythm documented here to be registered for the future.
	 * Code commented to avoid compilation errors in the server.
	 * 
	 * public int binarySearch(Integer[] array, Integer searchedNumber) {
	 * return this.binarySearch(array, 0, array.length - 1, searchedNumber);
	 * }
	 * 
	 * private int binarySearch(Integer[] array, int leftIndex, int rightIndex,
	 * Integer searchedNumber) {
	 * 
	 * if (leftIndex > rightIndex) {
	 * return -1;
	 * }
	 * 
	 * int middle = (leftIndex + rightIndex) / 2;
	 * 
	 * if (searchedNumber.compareTo(array[middle]) == 0) {
	 * return middle;
	 * }
	 * 
	 * if (searchedNumber.compareTo(array[middle]) < 0) {
	 * return this.binarySearch(array, leftIndex, middle - 1, searchedNumber);
	 * } else {
	 * return this.binarySearch(array, middle + 1, rightIndex, searchedNumber);
	 * }
	 * }
	 */

}
