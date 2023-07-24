import sort.SortableArray;

public class App {
  public static void main(String[] args) {
    int[] array = new int[] { 5, 1, 67, 3, 54, 12, 23, 4 };
    SortableArray sortableArray = new SortableArray(array);
    sortableArray.insertionSort();
    System.out.println(sortableArray.toString());
  }
}
