public class CountingSort {

    public static int[] sort(int[] arr) {
        int n = 256;//range of values, that can be present in array (e. g. if n ==3 then array can only contain[0,1,2])
        int[] countArr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        for (int i = 1; i < n; i++) {
            countArr[i] += countArr[i - 1];
        }

        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[countArr[arr[i]] - 1] = arr[i];
            --countArr[arr[i]];
        }
        System.arraycopy(sortedArr, 0, arr, 0, arr.length);
        return sortedArr;
    }


}
