import java.util.Arrays;
import java.util.Scanner;

public class QuickSortDemo {
    public static void main(String args[]) {
        QuickSort quickSort = new QuickSortImpl();
        int[] arr = getArrayFromConsole();
        System.out.println("array before sorting:");
        System.out.println(Arrays.toString(arr));
        quickSort.quickSort(arr);
        System.out.println("array after sorting:");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getArrayFromConsole() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter array elements separated by space : ");
        String[] tokens = scn.nextLine().split(" ");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        return arr;
    }
}
