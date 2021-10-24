public interface Heap {
    void printHeap(int[] heap);

    int parent(int currentIndex);

    int left(int currentIndex);

    int right(int currentIndex);

    int[] buildMaxHeap(int[] heap);

    void maxHeapify(int[] heap, int index);

    int[] buildMinHeap(int[] heap);

    void minHeapify(int[] heap, int index);

    int[] heapSortDesc(int[] arr);

    int[] heapSortAsc(int[] arr);

}
