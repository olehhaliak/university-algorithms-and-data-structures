import java.util.Arrays;

/**
 * @author OlehHaliak
 */
class MergeSort implements Sort {

    /**
     * merges two sub-arrays into one sorted array
     * @param arr array to merge
     * @param leftInd starting index of left array
     * @param middle index of elements, that separates left and right arrays
     * @param rightInd index of last element of right array
     */
    public void merge(int arr[], int leftInd, int middle, int rightInd) {
        int leftSize = middle - leftInd + 1;
        int rightSize = rightInd - middle;

        int leftArr[] = new int[leftSize];
        int rightArr[] = new int[rightSize];

        for (int i = 0; i < leftSize; ++i)
            leftArr[i] = arr[leftInd + i];
        for (int j = 0; j < rightSize; ++j)
            rightArr[j] = arr[middle + 1 + j];

        int i = 0, j = 0;
        int k = leftInd;
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Recursively split array to atomic size and then merges them back into single sorted arrey
     * @param arr array to sort
     * @param l index of first element of left sub-array
     * @param r index of last element of right sub-array
     */
     public void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /**
     * launches Merge sort algorythm
     * @see MergeSort#sort(int[], int, int)
     * @param arr array to sort
     */
    public void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

}
