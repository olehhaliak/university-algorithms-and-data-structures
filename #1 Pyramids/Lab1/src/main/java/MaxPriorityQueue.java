public interface MaxPriorityQueue {
    int heapMax();

    int heapExtractMax();

    void heapIncreaseKey(int keyIndex,int newKeyValue);

    void maxHeapInsert(int newValue);

    public void printHeap();

    void heapUpdate(int old,int newVal);
}
