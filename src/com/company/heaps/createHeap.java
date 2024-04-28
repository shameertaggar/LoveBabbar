package com.company.heaps;


//parent to child left = 2*i ## right = 2*i+1 (i = index)
// child to parent i====i/2
// leafs are from (n/2+1 ------n) n = size
import java.util.Arrays;

class heap{
    int arr[];
    int capacity;
    int size;

    heap(int capacity){
        this.arr = new int[capacity];
        this.capacity = capacity;
        //current no. of elements in heap
        this.size = 0;
    }

     void insert(int val){
        if (size == capacity){
            System.out.println("heap overflow");
            return;
        }
        //size increase kar jayega
        size++;
        int index = size;
        arr[index] = val;

        while (index >1){
            int parentIndex = index/2;
            if (arr[index] > arr[parentIndex]){
                int temp = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = temp;

                index = parentIndex;
            }else{
                break;
            }
        }

    }

    // for deletion replace root node with last node
    int deletion(){
        if (size == 0){
            System.out.println("heap underflow");
        }
        int ans = arr[1];
        //replacement
        arr[1] = arr[size];
        size--;
        int index = 1;
        while(index<=size){
            int left = 2*index;
            int right = 2*index + 1;

            int largestIndex = index;
            //check left child

            if (left <= size && arr[largestIndex] <arr[left]){
                largestIndex = left;
            }
            if (right <= size && arr[largestIndex] <arr[right]){
                largestIndex = right;
            }
            if (index == largestIndex){
                break;
            }else{
                int temp = arr[index];
                arr[index] = arr[largestIndex];
                arr[largestIndex] = temp;

                index = largestIndex;
            }
        }

        return ans;

    }

    void print(){
        for (int i = 0; i<=size; i++){
            System.out.print(arr[i]+" ");
        }
    }

    void heapify(int arr[], int n, int index) {
        System.out.println();
        for (int i = 1; i <= n; i++) {  // Start from index 1 instead of 0
            System.out.print(arr[i] + " ");
        }
        int left = 2 * index;
        int right = 2 * index + 1;
        int largestIndex = index;

        if (left <= n && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }
        if (right <= n && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        if (index != largestIndex) {
            int temp = arr[index];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapify(arr, n, largestIndex);
        }
    }

    void heapifyDeletion() {
        if (size == 0) {
            System.out.println("Heap underflow");
        }
        int ans = arr[1];
        arr[1] = arr[size];
        size--;

        int index = 1;
        while (index <= size / 2) {
            int largestIndex = index;
            heapify(arr, size, index);
            if (index == largestIndex) {
                break;
            }
            index = largestIndex;
        }
    }

    void buildHeap(int arr[],int n){
        for (int i = n/2; i >0; i--){
            heapify(arr,n,i );
        }
    }

    void heapSort(int arr[],int n){
        while (n!= 1){
            int temp = arr[1];
            arr[1] =arr[n];
            arr[n] = temp;
            n--;
            heapify(arr,n,1);
        }
    }
}
public class createHeap {
    public static void main(String[] args) {
        heap h = new heap(20);
        h.insert(10);
        h.insert(5);
        h.insert(20);
        h.insert(11);
        h.insert(6);
        System.out.println("printing the content of heap");
        h.print();
        int ans = h.deletion();

        System.out.println();
        System.out.println(ans);
        h.print();
        System.out.println("building heap");

        int arr[] = {0,10,5,20,11,6};
        h.buildHeap(arr,arr.length-1);
        h.heapifyDeletion();
        h.print();
    }
}
