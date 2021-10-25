import java.util.Scanner;

public class PriorityQueueMain {
    static MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueueImpl();
    static MinPriorityQueue minPriorityQueue = new MinPriorityQueueImpl();
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Choose queue implementation:");
            System.out.println("1) Max heap based");
            System.out.println("2) Min heap based");
            System.out.println("q) Exit");
            System.out.print(">> ");
            String input = scn.next();

            switch (input) {
                case "1":
                    maxPqDemo();
                    break;
                case "2":
                    minPqDemo();
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Bad input, try again");
            }
        }


    }

    private static void maxPqDemo() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Choose operation:");
       while (true){
           System.out.println("1) Insert val:");
           System.out.println("2) Extract val");
           System.out.println("3) Increase val");
           switch (scn.nextLine()) {
               case "1":
                   maxInsert();
                   break;
               case "2":
                   maxExtract();
                   break;
               case "3":
                   maxUpdate();
                   break;
               case "q":
                   System.exit(0);
               default:
                   System.out.println("Bad input, try again");
           }
       }
    }

    private static void maxExtract() {
        System.out.println("Extracted value : "+ maxPriorityQueue.heapExtractMax());
        System.out.println("-------Heap:-------");
        maxPriorityQueue.printHeap();
        System.out.println("-------------------");
    }

    private static void maxInsert() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter value >> ");
        maxPriorityQueue.maxHeapInsert(scn.nextInt());
        System.out.println("-------Heap:-------");
        maxPriorityQueue.printHeap();
        System.out.println("-------------------");
    }

    private static void maxUpdate() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter value to update and its new value separated by space(e.g [5 15]) >> ");
        maxPriorityQueue.heapUpdate(scn.nextInt(),scn.nextInt());
        System.out.println("-------Heap:-------");
        maxPriorityQueue.printHeap();
        System.out.println("-------------------");
    }
    private static void minPqDemo() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Choose operation:");
        while (true){
            System.out.println("1) Insert val:");
            System.out.println("2) Extract val");
            System.out.println("3) Decrease val");
            switch (scn.nextLine()) {
                case "1":
                    minInsert();
                    break;
                case "2":
                    minExtract();
                    break;
                case "3":
                    minUpdate();
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Bad input, try again");
            }
        }
    }

    private static void minExtract() {
        System.out.println("Extracted value : "+ minPriorityQueue.heapExtractMin());
        System.out.println("-------Heap:-------");
        minPriorityQueue.printHeap();
        System.out.println("-------------------");
    }

    private static void minInsert() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter value >> ");
        minPriorityQueue.minHeapInsert(scn.nextInt());
        System.out.println("-------Heap:-------");
        minPriorityQueue.printHeap();
        System.out.println("-------------------");
    }

    private static void minUpdate() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter value to update and its new value separated by space(e.g [5 15]) >> ");
        minPriorityQueue.heapUpdate(scn.nextInt(),scn.nextInt());
        System.out.println("-------Heap:-------");
        minPriorityQueue.printHeap();
        System.out.println("-------------------");
    }

}
