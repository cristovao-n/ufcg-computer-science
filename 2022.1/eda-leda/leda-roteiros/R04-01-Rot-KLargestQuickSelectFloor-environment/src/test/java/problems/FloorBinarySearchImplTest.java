package problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloorBinarySearchImplTest {

    private Integer[] testArray = new Integer[] { 5, 3, 6, 2, 8 };
    private FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();

    @Test
    public void testShouldFindFloorSmallerThanParam() {
        Integer floor = floorBinarySearch.floor(this.testArray, 4);
        assertEquals(Integer.valueOf(3), floor);
    }

    @Test
    public void testShouldFindFloorEqualsToParam() {
        Integer floor = floorBinarySearch.floor(this.testArray, 6);
        assertEquals(Integer.valueOf(6), floor);
    }

    @Test
    public void testShouldNotFindFloor() {
        Integer floor = floorBinarySearch.floor(this.testArray, 1);
        assertEquals(null, floor);
    }
}
