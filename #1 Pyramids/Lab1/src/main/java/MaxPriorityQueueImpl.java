public class MaxPriorityQueueImpl implements MaxPriorityQueue {
    int[] heap = new int[0];

    public int heapMax() {
        return heap[0];
    }

    public int heapExtractMax() {
        if (heap.length == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heapMax();
        swap(0, heap.length - 1, heap);
        heap = trimLast(heap);
        if (heap.length != 0) {
            maxHeapify(heap, 0);
        }
        return max;
    }

    public void heapIncreaseKey( int keyIndex, int newKeyValue) {
        if(newKeyValue<heap[keyIndex]){
            throw new RuntimeException("New key is less than current!");
        }
        heap[keyIndex] = newKeyValue;
        while (keyIndex>0&&heap[parent(keyIndex)]<heap[keyIndex]){
           swap(keyIndex,parent(keyIndex),heap);
           keyIndex = parent(keyIndex);
        }
    }

    public void maxHeapInsert( int newValue) {
        int[] newHeap = new int[heap.length+1];
        System.arraycopy(heap,0,newHeap,0,heap.length);
        heap = newHeap;
        heap[heap.length-1] = -10_000_000;
        heapIncreaseKey(heap.length-1,newValue);
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

    public void maxHeapify(int[] heap, int index) {
        int left = left(index);
        int right = right(index);
        int max = index;
        if (left < heap.length && heap[left] > heap[index]) {
            max = left;
        }
        if (right < heap.length && heap[right] > heap[max]) {
            max = right;
        }
        if (max != index) {
            swap(index, max, heap);
            maxHeapify(heap, max);
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

    public void printHeap(){
       HeapPrinter.printHeap(heap);
    }
}
