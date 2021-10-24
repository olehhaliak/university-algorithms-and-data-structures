// Java program to illustrate
// Randomised Quick Sort

import java.util.*;

class RandomizedSelect {
    Random rand = new Random();

    int randomizedSelect(int arr[],int statistic){
       return randomizedSelect(arr,0,arr.length-1,statistic);
    }

    int randomizedSelect(int arr[], int low, int high,int i) {
        if (low == high) {
            return arr[low];
        }
        int q = randomizedPartition(arr, low, high);
        int k = q - low + 1;
        if (i == k){
            return arr[q];
        } else if(i<k){
            return randomizedSelect(arr,low,q-1,i);
        }else {
            return randomizedSelect(arr,q+1,high,i-k);
        }
    }

    int randomizedPartition(int arr[], int low, int high) {
        int pivotIndex = rand.nextInt(high - low) + low;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high);
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void randomizedQuickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            randomizedQuickSort(arr, pi + 1, high);
            randomizedQuickSort(arr, low, pi - 1);
        }
    }

}