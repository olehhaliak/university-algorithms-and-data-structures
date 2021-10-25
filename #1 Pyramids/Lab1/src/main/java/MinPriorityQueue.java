public interface MinPriorityQueue {
    int heapMin();

    int heapExtractMin();

    void heapDecreaseKey(int keyIndex, int newKeyValue);

    void minHeapInsert(int newValue);

     void printHeap();

    void heapUpdate(int old,int newVal);
}
