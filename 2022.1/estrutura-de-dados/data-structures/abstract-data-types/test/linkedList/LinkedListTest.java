package test.linkedList;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import src.linkedList.LinkedList;

public class LinkedListTest {

  private LinkedList<Integer> emptyList = new LinkedList<Integer>();
  private LinkedList<Integer> list = new LinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
  private static final Integer VALUE = 10;
  private static final int INDEX_OUT_LENGTH = 7;
  private static final int NEGATIVE_INDEX = -1;

  @Test
  public void testAddEmptyList() {
    this.emptyList.add(VALUE);
    assertTrue(this.emptyList.contains(VALUE));
  }

  @Test
  public void testAddAtIndex() {
    final int INDEX = 6;
    this.list.add(VALUE, INDEX);
    assertEquals(VALUE, this.list.get(INDEX));
  }

  @Test
  public void testAddInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      this.list.add(1, INDEX_OUT_LENGTH);
    });
  }

  @Test
  public void testAddAtNegativeIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      this.list.add(1, NEGATIVE_INDEX);
    });
  }

  @Test
  public void testGet() {
    assertEquals(6, this.list.get(5));
  }

  @Test
  public void testGetInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      this.list.get(INDEX_OUT_LENGTH);
    });
  }

  @Test
  public void testGetNegativeIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      this.list.get(NEGATIVE_INDEX);
    });
  }

  @Test
  public void testRemoveAtIndex() {
    this.list.remove(3);
    assertFalse(this.list.contains(4));

  }

  @Test
  public void testRemoveAtLastIndex() {
    this.list.remove(6);
    assertFalse(this.list.contains(7));
  }

  @Test
  public void testRemoveInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      this.list.remove(INDEX_OUT_LENGTH);
    });
  }

  @Test
  public void testRemoveNegativeIndex() {

    assertThrows(IndexOutOfBoundsException.class, () -> {
      this.list.remove(NEGATIVE_INDEX);
    });
  }

  @Test
  public void testContains() {
    int k = 10;
    assertFalse(this.list.contains(k));
  }

  @Test
  public void testDoesNotContain() {
    int k = 10;
    this.list.add(Integer.valueOf(k));
    assertTrue(this.list.contains(k));
  }

  @Test
  public void testLength() {
    assertEquals(7, this.list.length());
  }

  @Test
  public void testEmpty() {
    assertTrue(this.emptyList.isEmpty());
  }

  @Test
  public void testNonEmpty() {
    assertFalse(this.list.isEmpty());
  }

  @Test
  public void testToStringEmptyList() {
    assertEquals("[]", this.emptyList.toString());
  }

  @Test
  public void testToStringNonEmptyList() {
    assertEquals("[1, 2, 3, 4, 5, 6, 7]", this.list.toString());
  }

}
