package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer[] result = new Integer[array.length];
		Integer[] invertedResult = new Integer[array.length];
		Integer parsedNumber = (int) numero;

		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			Integer root = this.extractRootElement();
			result[i] = root;
			invertedResult[array.length - 1 - i] = root;
		}

		Integer[] ascendingResult = this.getAscendingResult(result, invertedResult);

		for (int i = ascendingResult.length - 1; i >= 0; i--) {
			if (ascendingResult[i].compareTo(parsedNumber) <= 0) {
				return ascendingResult[i];
			}
		}

		return null;

	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer[] result = new Integer[array.length];
		Integer[] invertedResult = new Integer[array.length];
		Integer parsedNumber = (int) numero;

		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			Integer root = this.extractRootElement();
			result[i] = root;
			invertedResult[array.length - 1 - i] = root;
		}

		Integer[] ascendingResult = this.getAscendingResult(result, invertedResult);

		for (int i = 0; i < ascendingResult.length; i++) {
			if (ascendingResult[i].compareTo(parsedNumber) >= 0) {
				return ascendingResult[i];
			}
		}

		return null;
	}

	private Integer[] getAscendingResult(Integer[] result, Integer[] invertedResult) {
		if (result[0].compareTo(invertedResult[0]) < 0) {
			return result;
		} else {
			return invertedResult;
		}
	}

}
