import java.util.Arrays;

public class RadixSort {
    static int getMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    static void countSort(int arr[], int exp) {
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int[] sortedArray = new int[arr.length];
        for (i = arr.length - 1; i >= 0; i--) {
            sortedArray[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }

    static void radixSort(int arr[]) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

}