package orderStatistic;

import java.util.Arrays;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1].
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os n-k maiores elementos, pode-se pegar todas as
 * estatisticas de ordem maiores que n-k.
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 * Voce pode criar ainda um array de tamanho n-k que vai armazenar apenas
 * os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala
 * para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 * ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 * Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T> {

	@Override
	public T[] getKLargest(T[] array, int k) {
		if (k > array.length) {
			return Arrays.copyOf(array, 0);
		}

		T[] result = Arrays.copyOf(array, k);

		for (int i = array.length - k; i < array.length; i++) {
			result[i - (array.length - k)] = this.orderStatistics(array, i + 1);
		}

		return result;

	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k) {
		for (int i = 0; i < k; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[smallestIndex]) < 0) {
					smallestIndex = j;
				}
			}
			Util.swap(array, smallestIndex, i);
		}
		return array[k - 1];

	}
}
