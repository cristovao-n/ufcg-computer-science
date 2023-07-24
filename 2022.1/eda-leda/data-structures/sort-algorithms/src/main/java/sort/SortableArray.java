package sort;

import java.util.Arrays;

public class SortableArray {
  private int[] array;

  public SortableArray(int[] array) {
    this.array = array;
  }

  public int[] getArray() {
    return this.array;
  }

  public void selectionSort() {

    for (int i = 0; i < this.array.length; i++) {
      int smallestNumberIndex = i;

      for (int j = i + 1; j < this.array.length; j++) {
        if (this.array[j] < this.array[smallestNumberIndex]) {
          smallestNumberIndex = j;
        }
      }
      this.swap(i, smallestNumberIndex);
    }

  }

  public void insertionSort() {
    for (int i = 1; i < this.array.length; i++) {
      int j = i;
      while (true) {
        if (j == 0) {
          break;
        }
        boolean shouldBeSwapped = this.array[j] < this.array[j - 1];
        if (!shouldBeSwapped) {
          break;
        }

        this.swap(j, j - 1);
        j -= 1;

      }
    }
  }

  public int[] mergeSortedArrays(int[] arrayI, int[] arrayJ) {
    int[] result = new int[arrayI.length + arrayJ.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < arrayI.length && j < arrayJ.length) {
      if (arrayI[i] <= arrayJ[j]) {
        result[k] = arrayI[i];
        i += 1;
      } else {
        result[k] = arrayJ[j];
        j += 1;
      }
      k += 1;
    }

    while (i < arrayI.length) {
      result[k] = arrayI[i];
      i += 1;
      k += 1;
    }

    while (j < arrayJ.length) {
      result[k] = arrayJ[j];
      j += 1;
      k += 1;
    }

    return result;
  }

  private void swap(int sourceIndex, int targetIndex) {
    int aux = this.array[targetIndex];
    this.array[targetIndex] = this.array[sourceIndex];
    this.array[sourceIndex] = aux;
  }

  public String toString() {
    return Arrays.toString(this.array);
  }
}