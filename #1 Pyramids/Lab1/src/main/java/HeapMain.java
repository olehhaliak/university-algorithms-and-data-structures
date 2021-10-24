import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeapMain {

    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Choose option:");
            System.out.println("1) Max heap sort");
            System.out.println("2) Min heap sort");
            System.out.println("q) Exit");
            System.out.print(">> ");
            String input = scn.next();

            switch (input) {
                case "1":
                    maxHeapDemo();
                    break;
                case "2":
                    minHeapDemo();
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Bad input, try again");
            }
        }
    }

    private static void minHeapDemo() {
        Heap heap = new HeapImpl();
        int heapArr[] = getArrayFromConsole();
        System.out.println("You entered :"+Arrays.toString(heapArr));
        System.out.println("Your array represented as heap:");
        heap.printHeap(heapArr);
        System.out.println("Sorting using Min Heap...");
        System.out.println("Result :"+Arrays.toString(heap.heapSortDesc(heapArr)));
        System.out.println();
    }

    private static void maxHeapDemo() {
        Heap heap = new HeapImpl();
        int heapArr[] = getArrayFromConsole();
        System.out.println("You entered :"+Arrays.toString(heapArr));
        System.out.println("Your array represented as heap:");
        heap.printHeap(heapArr);
        System.out.println("Sorting using Max Heap...");
        System.out.println("Result :"+Arrays.toString(heap.heapSortAsc(heapArr)));
        System.out.println();
    }

    private static int[] getArrayFromConsole() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter array separated by space:");
        String[] strs = scn.nextLine().trim().split(" ");
        int arr[] = new int[strs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }
}
