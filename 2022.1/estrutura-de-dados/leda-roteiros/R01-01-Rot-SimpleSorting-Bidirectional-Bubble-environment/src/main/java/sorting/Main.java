package sorting;

import java.util.Arrays;
import java.util.Random;

import sorting.simpleSorting.BubbleSort;

public class Main {
    public static void main(String[] args) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

        Integer[] array = new Integer[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10000);
        }

        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
