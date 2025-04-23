import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RadixSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testUnsortedArray() {
        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(arr);
        assertArrayEquals(new int[]{94, 99, 182, 264, 295, 356, 472, 491, 543, 692, 783}, arr);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66, 170};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(arr);
        assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 170, 802}, arr);
    }

}