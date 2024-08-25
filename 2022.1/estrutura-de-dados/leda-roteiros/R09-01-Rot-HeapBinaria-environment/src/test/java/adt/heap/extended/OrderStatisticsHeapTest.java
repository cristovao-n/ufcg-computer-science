package adt.heap.extended;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatisticsHeapImpl;

public class OrderStatisticsHeapTest {
  private OrderStatisticsHeapImpl<Integer> orderStatisticsHeap;
  private Integer[] array;

  @Before
  public void setUp() {
    this.orderStatisticsHeap = new OrderStatisticsHeapImpl<Integer>();
    this.array = new Integer[] { 839, 19, 2019, 392, 583, 94, 64, 12, 53 };
  }

  @Test
  public void testOrderStatisticsValidOrder() {
    Integer[] sortedArray = Arrays.copyOf(this.array, this.array.length);
    Arrays.sort(sortedArray);

    for (int i = 0; i < sortedArray.length; i++) {
      Integer result = this.orderStatisticsHeap.getOrderStatistics(this.array, i + 1);
      assertEquals(sortedArray[i], result);
    }
  }

  @Test
  public void testOrderStatisticsSmallerInvalidOrder() {
    Integer result = this.orderStatisticsHeap.getOrderStatistics(this.array, 0);
    assertNull(result);
  }

  @Test
  public void testOrderStatisticsGreaterInvalidOrder() {
    Integer result = this.orderStatisticsHeap.getOrderStatistics(this.array, this.array.length + 1);
    assertNull(result);
  }

}
