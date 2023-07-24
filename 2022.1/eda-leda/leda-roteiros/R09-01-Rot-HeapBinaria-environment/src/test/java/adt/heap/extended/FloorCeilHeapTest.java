package adt.heap.extended;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;

public class FloorCeilHeapTest {
  private FloorCeilHeapImpl floorCeilHeap;
  private Integer[] array;

  @Before
  public void setUp() {
    this.floorCeilHeap = new FloorCeilHeapImpl(new ComparatorMinHeap<Integer>());
    this.array = new Integer[] { 839, 19, 2019, 392, 583, 94, 64, 12, 53 };
  }

  @Test
  public void testFloorSmallerNumber() {
    Integer result = this.floorCeilHeap.floor(this.array, 300);
    assertEquals(Integer.valueOf(94), result);
  }

  @Test
  public void testFloorSameNumber() {
    Integer result = this.floorCeilHeap.floor(this.array, 392);
    assertEquals(Integer.valueOf(392), result);
  }

  @Test
  public void testFloorMissingNumber() {
    Integer result = this.floorCeilHeap.floor(this.array, 11);
    assertNull(result);
  }

  @Test
  public void testCeilGreaterNumber() {
    Integer result = this.floorCeilHeap.ceil(this.array, 500);
    assertEquals(Integer.valueOf(583), result);
  }

  @Test
  public void testCeilSameNumber() {
    Integer result = this.floorCeilHeap.ceil(this.array, 392);
    assertEquals(Integer.valueOf(392), result);
  }

  @Test
  public void testCeilMissingNumber() {
    Integer result = this.floorCeilHeap.ceil(this.array, 2020);
    assertNull(result);
  }

}
