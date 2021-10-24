import org.junit.jupiter.api.Test;

class MaxPriorityQueueImplTest {
    @Test
    void name() {
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueueImpl();
        maxPriorityQueue.maxHeapInsert(5);
        maxPriorityQueue.maxHeapInsert(4);
        maxPriorityQueue.maxHeapInsert(3);
        maxPriorityQueue.maxHeapInsert(2);
        maxPriorityQueue.maxHeapInsert(1);
        maxPriorityQueue.maxHeapInsert(40);
        maxPriorityQueue.maxHeapInsert(30);
        maxPriorityQueue.maxHeapInsert(20);
        maxPriorityQueue.maxHeapInsert(10);
        maxPriorityQueue.printHeap();
        System.out.println(maxPriorityQueue.heapExtractMax());
        System.out.println(maxPriorityQueue.heapExtractMax());
        System.out.println(maxPriorityQueue.heapExtractMax());
        System.out.println(maxPriorityQueue.heapExtractMax());
        maxPriorityQueue.printHeap();
    }
}