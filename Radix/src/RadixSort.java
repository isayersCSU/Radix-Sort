import java.util.Arrays;

public class RadixSort {

    public void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // Find the maximum number to know the number of digits
        int max = Arrays.stream(arr).max().orElse(0);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is the current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10]; // Digit count array (0-9)
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        RadixSort radixSort = new RadixSort();
        System.out.println("Original array: " + Arrays.toString(arr));
        radixSort.radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}