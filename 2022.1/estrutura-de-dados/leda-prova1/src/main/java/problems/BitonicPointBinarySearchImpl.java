package problems;

public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T> {

  @Override
  public T bitonicPoint(T[] array) {
    boolean isArrayEmpty = array.length == 0;
    if (isArrayEmpty) {
      return null;
    }

    int bitonicIndex = this.binarySearch(array, 0, array.length - 1);
    return array[bitonicIndex];
  }

  private int binarySearch(T[] array, int leftIndex, int rightIndex) {
    int middle = (leftIndex + rightIndex) / 2;

    boolean hasValidNextElement = middle + 1 <= rightIndex;
    boolean hasValidPreviousElement = middle - 1 >= leftIndex;

    if (!hasValidPreviousElement && !hasValidNextElement) {
      return middle;
    }

    if (hasValidPreviousElement && hasValidNextElement) {
      return handlePreviousAndNextValid(array, leftIndex, rightIndex, middle);
    }

    if (hasValidNextElement) {
      return handleOnlyNextValid(array, leftIndex, rightIndex, middle);
    }

    return handleOnlyPreviousValid(array, leftIndex, rightIndex, middle);

  }

  private int handlePreviousAndNextValid(T[] array, int leftIndex, int rightIndex, int middle) {
    boolean currentIsSmallerThanNext = array[middle].compareTo(array[middle + 1]) < 0;
    if (currentIsSmallerThanNext) {
      return this.binarySearch(array, middle + 1, rightIndex);
    } else {
      return this.binarySearch(array, leftIndex, middle);
    }
  }

  private int handleOnlyNextValid(T[] array, int leftIndex, int rightIndex, int middle) {
    boolean currentIsSmallerThanNext = array[middle].compareTo(array[middle + 1]) < 0;
    if (currentIsSmallerThanNext) {
      return this.binarySearch(array, middle + 1, rightIndex);
    } else {
      return middle;
    }
  }

  private int handleOnlyPreviousValid(T[] array, int leftIndex, int rightIndex, int middle) {
    boolean currentIsSmallerThanPrevious = array[middle].compareTo(array[middle - 1]) < 0;
    if (currentIsSmallerThanPrevious) {
      return this.binarySearch(array, leftIndex, middle - 1);
    } else {
      return middle;
    }
  }

}