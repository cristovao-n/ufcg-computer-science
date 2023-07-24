package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationTest {
  private SimpleBSTManipulation<Integer> bstManipulation;
  private BSTImpl<Integer> sameTree1;
  private BSTImpl<Integer> sameTree2;
  private BSTImpl<Integer> similarTree1;
  private BSTImpl<Integer> notSameTree1;
  private BSTImpl<Integer> emptyTree;

  private void fillTrees() {
    Integer[] numbers = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
    for (int number : numbers) {
      sameTree1.insert(number);
      sameTree2.insert(number);
      similarTree1.insert(number * 2);
    }

    notSameTree1.insert(1);

  }

  @Before
  public void setUp() {
    this.bstManipulation = new SimpleBSTManipulationImpl<Integer>();
    this.sameTree1 = new BSTImpl<Integer>();
    this.sameTree2 = new BSTImpl<Integer>();
    this.similarTree1 = new BSTImpl<Integer>();
    this.notSameTree1 = new BSTImpl<Integer>();
    this.emptyTree = new BSTImpl<Integer>();
  }

  @Test
  public void testEqualsSameTrees() {
    this.fillTrees();
    assertTrue(this.bstManipulation.equals(this.sameTree1, this.sameTree2));
  }

  @Test
  public void testEqualsSimilarTrees() {
    this.fillTrees();
    assertFalse(this.bstManipulation.equals(this.sameTree1, this.similarTree1));
  }

  @Test
  public void testEqualsDifferentTrees() {
    this.fillTrees();
    assertFalse(this.bstManipulation.equals(this.sameTree1, this.notSameTree1));
  }

  @Test
  public void testIsSimilarSameTrees() {
    this.fillTrees();
    assertTrue(this.bstManipulation.isSimilar(this.sameTree1, this.sameTree2));
  }

  @Test
  public void testIsSimilarSimilarTrees() {
    this.fillTrees();
    assertTrue(this.bstManipulation.isSimilar(this.sameTree1, this.similarTree1));
  }

  @Test
  public void testIsSimilarNonSimilarTrees() {
    this.fillTrees();
    assertFalse(this.bstManipulation.isSimilar(this.sameTree1, this.notSameTree1));
  }

  @Test
  public void testOrderStatistics1() {
    this.fillTrees();
    assertEquals(Integer.valueOf(-34), this.bstManipulation.orderStatistic(this.sameTree1, 2));
  }

  @Test
  public void testOrderStatistics2() {
    this.fillTrees();
    assertEquals(Integer.valueOf(232), this.bstManipulation.orderStatistic(this.sameTree1, this.sameTree1.size()));
  }

  @Test
  public void testOrderStatisticsOutOfRange() {
    this.fillTrees();
    assertNull(this.bstManipulation.orderStatistic(this.sameTree1, this.sameTree1.size() + 1));
    assertNull(this.bstManipulation.orderStatistic(this.sameTree1, 0));
  }

}
