package problems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BitonicPointBinarySearchImplTest {
    private Integer[] emptyArray = new Integer[]{};
    private Integer[] oneElementArray = new Integer[]{ 10 };
    private Integer[] oddArray = new Integer[]{4, 5, 1};
    private Integer[] evenArray = new Integer[]{2, 6, 3, 1};
    private Integer[] bitonicAtStartArray = new Integer[]{6, 4, 3, 2, 1};
    private Integer[] bitonicAtEndArray = new Integer[]{2, 3, 4, 6, 7};
    private Integer[] bitonicAtMiddleArray = new Integer[]{1, 4, 5, 6, 3, 2};

    private BitonicPointBinarySearchImpl<Integer> bitonicPointBinarySearch = new BitonicPointBinarySearchImpl<Integer>();

    @Test
    public void testEmptyArray() {
        assertNull(bitonicPointBinarySearch.bitonicPoint(emptyArray));
    }

    @Test
    public void testOneElementArray() {
        Integer bitonicPoint = bitonicPointBinarySearch.bitonicPoint(oneElementArray);
        assertEquals(Integer.valueOf(10), bitonicPoint);
    }

    @Test
    public void testOddArray() {
        Integer bitonicPoint = bitonicPointBinarySearch.bitonicPoint(oddArray);
        assertEquals(Integer.valueOf(5), bitonicPoint);
    }

    @Test
    public void testEvenArray() {
        Integer bitonicPoint = bitonicPointBinarySearch.bitonicPoint(evenArray);
        assertEquals(Integer.valueOf(6), bitonicPoint);
    }

    @Test
    public void testBitonicAtStartArray() {
        Integer bitonicPoint = bitonicPointBinarySearch.bitonicPoint(bitonicAtStartArray);
        assertEquals(Integer.valueOf(6), bitonicPoint);
    }

    @Test
    public void testBitonicAtEndArray() {
        Integer bitonicPoint = bitonicPointBinarySearch.bitonicPoint(bitonicAtEndArray);
        assertEquals(Integer.valueOf(7), bitonicPoint);
    }

    @Test
    public void testBitonicAtMiddleArray() {
        Integer bitonicPoint = bitonicPointBinarySearch.bitonicPoint(bitonicAtMiddleArray);
        assertEquals(Integer.valueOf(6), bitonicPoint);
    }
}
