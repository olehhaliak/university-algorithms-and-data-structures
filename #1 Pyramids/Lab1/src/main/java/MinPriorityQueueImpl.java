public class MinPriorityQueueImpl implements MinPriorityQueue {

    int[] heap = new int[0];

    @Override
    public int heapMin() {
        return heap[0];
    }

    @Override
    public int heapExtractMin() {
        if (heap.length == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int min = heapMin();
        swap(0, heap.length - 1, heap);
        heap = trimLast(heap);
        if (heap.length != 0) {
            minHeapify(heap, 0);
        }
        return min;
    }

    public void heapUpdate(int old,int newVal){
        for (int i = 0; i < heap.length; i++) {
            if(heap[i]== old){
                heapDecreaseKey(i,newVal);
                return;
            }
        }
        System.out.println("No such value present in heap");
    }
    @Override
    public void heapDecreaseKey(int keyIndex, int newKeyValue) {
        if (newKeyValue > heap[keyIndex]) {
            throw new RuntimeException("New key is bigger than current!");
        }
        heap[keyIndex] = newKeyValue;
        while (keyIndex > 0 && heap[parent(keyIndex)] > heap[keyIndex]) {
            swap(keyIndex, parent(keyIndex), heap);
            keyIndex = parent(keyIndex);
        }
    }

    @Override
    public void minHeapInsert(int newValue) {
        int[] newHeap = new int[heap.length + 1];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
        heap[heap.length - 1] = 10_000_000;
        heapDecreaseKey(heap.length - 1, newValue);
    }

    @Override
    public void printHeap() {
        HeapPrinter.printHeap(heap);
    }

    void swap(int firstIndex, int secondIndex, int[] arr) {
        int temp = arr[secondIndex];
        arr[secondIndex] = arr[firstIndex];
        arr[firstIndex] = temp;
    }

    private int[] trimLast(int[] arr) {
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length - 1);
        return newArr;
    }

    public void minHeapify(int[] heap, int index) {
        int left = left(index);
        int right = right(index);
        int min = index;
        if (left < heap.length && heap[left] < heap[index]) {
            min = left;
        }
        if (right < heap.length && heap[right] < heap[min]) {
            min = right;
        }
        if (min != index) {
            swap(index, min, heap);
            minHeapify(heap, min);
        }
    }

    public int parent(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    public int left(int currentIndex) {
        return 2 * currentIndex + 1;
    }

    public int right(int currentIndex) {
        return 2 * currentIndex + 2;
    }

}
