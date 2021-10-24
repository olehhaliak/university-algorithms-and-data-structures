import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapImplTest {
    Heap heap = new HeapImpl();
    MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueueImpl();
    @Test
    void parentTest() {
       assertSame(1,heap.parent(4)) ;
    }

    @Test
    void leftTest() {
        assertSame(5,heap.left(2));
        assertSame(1,heap.left(0));
    }

    @Test
    void rightTest() {
        assertSame(6,heap.right(2));
        assertSame(2,heap.right(0));
    }

    @Test
    void maxHeapifyTest() {
        int[] arr = {100,200,300,400,500,600,700};
        System.out.println("===BEFORE===");
        HeapPrinter.printHeap(arr);
        heap.maxHeapify(arr,0);
        System.out.println("===AFTER===");
        HeapPrinter.printHeap(arr);
    }


    @Test
    void name() {
    }

    @Test
    void printTest() {
        int[] i = new int[]{100,200,300,400,500,600,700,800,900,100,101,102,103,104,105};
        heap.printHeap(i);
    }

    @Test
    void buildMaxHeapTest() {
        int[] arr = {100,200,300,400,500,600,700};
        System.out.println("===BEFORE===");
        HeapPrinter.printHeap(arr);
        System.out.println("===AFTER===");
        arr = heap.buildMaxHeap(arr);
        HeapPrinter.printHeap(arr);
    }

    @Test
    void heapSortTest() {
        int[] arr = {300,500,400,100,500,600,700};
//        heap.buildMaxHeap(arr);
//        heap.printHeap(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(heap.heapSortAsc(arr)));
//        HeapPrinter.printHeap(arr);
    }

    @Test
    void minHeapifyTest() {
        int[] arr = {700,600,500,400,300,200,100};
        System.out.println("===BEFORE===");
        HeapPrinter.printHeap(arr);
        heap.minHeapify(arr,0);
        System.out.println("===AFTER===");
        HeapPrinter.printHeap(arr);
    }

    @Test
    void buildMinHeapTest() {
        int[] arr = {7,6,5,4,3,2,1};
        System.out.println("===BEFORE===");
        HeapPrinter.printHeap(arr);
        System.out.println("===AFTER===");
        arr = heap.buildMinHeap(arr);
        HeapPrinter.printHeap(arr);
    }

    @Test
    void heapSortAscTest() {
        int[] arr = {700,600,500,400,300,200,100};
        System.out.println("===BEFORE===");
        System.out.println(Arrays.toString(arr));
        System.out.println("===AFTER===");
        System.out.println(Arrays.toString(heap.heapSortAsc(arr)));
    }

    @Test
    void heapSortDescTest() {
        int[] arr = {100,200,300,400,500,600,700};
        System.out.println("===BEFORE===");
        System.out.println(Arrays.toString(arr));
        System.out.println("===AFTER===");
        System.out.println(Arrays.toString(heap.heapSortDesc(arr)));
    }


}