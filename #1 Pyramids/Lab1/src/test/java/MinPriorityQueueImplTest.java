import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPriorityQueueImplTest {

    @Test
    void name() {
        MinPriorityQueue queue = new MinPriorityQueueImpl();
        queue.minHeapInsert(5);
        queue.minHeapInsert(4);
        queue.minHeapInsert(3);
        queue.minHeapInsert(2);
        queue.minHeapInsert(1);
        queue.minHeapInsert(6);
        queue.minHeapInsert(5);
        queue.printHeap();
        System.out.println(queue.heapExtractMin());
        System.out.println(queue.heapExtractMin());
        System.out.println(queue.heapExtractMin());
        queue.printHeap();
        System.out.println(queue.heapExtractMin());
        System.out.println(queue.heapExtractMin());
        System.out.println(queue.heapExtractMin());
        System.out.println(queue.heapExtractMin());
        queue.printHeap();
    }
}