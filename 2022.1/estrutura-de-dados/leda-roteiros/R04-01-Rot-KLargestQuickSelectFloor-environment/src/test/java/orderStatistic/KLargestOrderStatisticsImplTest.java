package orderStatistic;

import static org.junit.Assert.*;

import org.junit.Test;

public class KLargestOrderStatisticsImplTest {

  private Integer[] testArray = new Integer[] { 5, 3, 6, 2, 8 };
  private KLargestOrderStatisticsImpl<Integer> kLargestOrderStatistics = new KLargestOrderStatisticsImpl<Integer>();

  @Test
  public void testShouldReturnKLargestElementsOfArray01() {
    Integer[] kLargest = kLargestOrderStatistics.getKLargest(this.testArray, 4);
    Integer[] expectedResult = new Integer[] { 3, 5, 6, 8 };
    assertArrayEquals(expectedResult, kLargest);
  }

  @Test
  public void testShouldReturnKLargestElementsOfArray02() {
    Integer[] kLargest = kLargestOrderStatistics.getKLargest(this.testArray, 5);
    Integer[] expectedResult = new Integer[] { 2, 3, 5, 6, 8 };
    assertArrayEquals(expectedResult, kLargest);
  }

  @Test
  public void testShouldReturnKLargestElementsOfArray03() {
    Integer[] kLargest = kLargestOrderStatistics.getKLargest(this.testArray, 1);
    Integer[] expectedResult = new Integer[] { 8 };
    assertArrayEquals(expectedResult, kLargest);
  }

  @Test
  public void testShouldReturnKLargestElementsOfArray04() {
    Integer[] kLargest = kLargestOrderStatistics.getKLargest(this.testArray, 2);
    Integer[] expectedResult = new Integer[] { 6, 8 };
    assertArrayEquals(expectedResult, kLargest);
  }

  @Test
  public void testShouldReturnEmptyArray01() {
    Integer[] kLargest = kLargestOrderStatistics.getKLargest(this.testArray, 0);
    Integer[] expectedResult = new Integer[] {};
    assertArrayEquals(expectedResult, kLargest);
  }

  @Test
  public void testShouldReturnEmptyArray02() {
    Integer[] kLargest = kLargestOrderStatistics.getKLargest(this.testArray, 6);
    Integer[] expectedResult = new Integer[] {};
    assertArrayEquals(expectedResult, kLargest);
  }
}
