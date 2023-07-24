package sorting.linearSorting;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ExtendedCountingSort countingSort = new ExtendedCountingSort();
        Integer[] array = new Integer[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(1000) - 500;
        }
        long timeBeforeSort = System.currentTimeMillis();
        countingSort.sort(array);
        long timeAfterSort = System.currentTimeMillis();

        long executionTime = timeAfterSort - timeBeforeSort;
        System.out.println(timeBeforeSort);
        System.out.println(timeAfterSort);
        System.out.println("Tempo de execucão: " + executionTime);
    }
}
