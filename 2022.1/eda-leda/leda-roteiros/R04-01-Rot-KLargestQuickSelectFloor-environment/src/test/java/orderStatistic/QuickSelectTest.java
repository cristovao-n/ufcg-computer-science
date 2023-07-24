package orderStatistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class QuickSelectTest {
  private Integer[] testArray = new Integer[] { 5, 3, 6, 2, 8 };
  private QuickSelect<Integer> quickSelect = new QuickSelect<Integer>();

  @Test
  public void testShouldReturnCorrectElementOfOrderStatistic01() {
    Integer result = quickSelect.quickSelect(this.testArray, 4);
    assertEquals(Integer.valueOf(6), result);
  }

  @Test
  public void testShouldReturnCorrectElementOfOrderStatistic02() {
    Integer result = quickSelect.quickSelect(testArray, testArray.length);
    assertEquals(Integer.valueOf(8), result);
  }

  @Test
  public void testShouldReturnNullIfKIsGreatherThanArrayLength() {
    Integer result = quickSelect.quickSelect(this.testArray, 6);
    assertNull(result);
  }

  @Test
  public void testShouldReturnNullIfArrayIsEmpty() {
    Integer result = quickSelect.quickSelect(new Integer[] {}, 2);
    assertNull(result);
  }

}
