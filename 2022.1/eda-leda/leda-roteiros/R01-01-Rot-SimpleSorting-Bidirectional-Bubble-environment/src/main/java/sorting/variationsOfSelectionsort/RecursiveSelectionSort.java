package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || array.length <= 1) {
			return;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			int smallestIndex = this.getSmallestElementIndex(array, i, rightIndex);
			Util.swap(array, smallestIndex, i);
		}

		this.sort(array, leftIndex + 1, rightIndex);

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
