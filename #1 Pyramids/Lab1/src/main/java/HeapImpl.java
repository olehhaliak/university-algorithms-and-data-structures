import java.util.Arrays;

public class HeapImpl implements Heap {

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

    @Override
    public void printHeap(int[] heap) {
        HeapPrinter.printHeap(heap);
    }

    @Override
    public int parent(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    public int left(int currentIndex) {
        return 2 * currentIndex + 1;
    }

    @Override
    public int right(int currentIndex) {
        return 2 * currentIndex + 2;
    }

    @Override
    public int[] buildMaxHeap(int[] heap) {
        for (int i = heap.length / 2; i >= 0; i--) {
            maxHeapify(heap, i);
        }
        return heap;
    }


    @Override
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

    @Override
    public int[] heapSortAsc(int[] arr) {
        int[] sortedArr = new int[arr.length];
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(0, i, arr);
            sortedArr[i] = arr[i];
            arr = trimLast(arr);
            maxHeapify(arr, 0);
        }
        return sortedArr;
    }

    @Override
    public int[] buildMinHeap(int[] heap) {
        for (int i = heap.length / 2; i >= 0; i--) {
            minHeapify(heap, i);
        }
        return heap;
    }

    @Override
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

    @Override
    public int[] heapSortDesc(int[] arr) {
        int[] sortedArr = new int[arr.length];
        buildMinHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(0, i, arr);
            sortedArr[i] = arr[i];
            arr = trimLast(arr);
            minHeapify(arr, 0);
        }
        return sortedArr;
    }



}
