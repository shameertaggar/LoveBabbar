package com.company.heaps;

class heep{
    int arr[];
    int size ;
    int capacity;

    heep(int capacity){
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    void insert(int val){
        if (size == capacity){
            System.out.println("heep overflow");
            return;
        }
        size++;
        int index = size;
        arr[index] = val;
        heapify(arr,size,index);
    }

    void heapify(int arr[], int n, int index){
        System.out.println("heapify");
        int left = 2*index;
        int right = 2*index+1;
        int largestIndex = index;

        if (left <=n && arr[largestIndex] <arr[left]){
            largestIndex = left;
        }
        if (right <= n && arr[largestIndex] <arr[right]){
            largestIndex = right;
        }

        if (index!=largestIndex){
            int temp = arr[index];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;
            index = largestIndex;
            heapify(arr,n,index);
        }
    }
    void print(){
        for (int i = 0; i<=size; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
public class create {
    public static void main(String[] args) {
        heep h = new heep(20);
        h.insert(10);
        h.insert(20);
        h.insert(5);
        h.insert(11);
        h.insert(6);
        h.print();
    }
}
