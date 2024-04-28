package com.company.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class heapWithPriorityQueue {

    static void withMaxheap(int arr[], int k){
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i<k; i++){
            p.add(arr[i]);
        }

        for (int i = k; i<arr.length;i++){
            if (arr[i] < p.peek()){
                p.remove();
                p.add(arr[i]);
            }
        }

        System.out.println("kth smallest element is : " + p.peek());
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(50);

        System.out.println("Top element : "+pq.peek());
        pq.remove();
        System.out.println("Top element : "+pq.peek());
        System.out.println("Size of pq : " + pq.size());
        if (pq.isEmpty()){
            System.out.println("pq is empty");

        }
        else{
            System.out.println("pq is not empty");
        }

        System.out.println("pq : "+pq);
        pq.add(3);
        pq.add(6);
        pq.add(54);
        pq.add(23);
        System.out.println("pq : "+pq);

        int k = 4;
        for (int i = 0; i<k-1; i++){
            System.out.println("removed : "+ pq.remove());;
        }
        int arr[] = {3,5,4,6,9,8,7};
        withMaxheap(arr,k);
        System.out.println("pq : "+pq);

        System.out.println("kth smallest element : " + pq.peek());


    }
}
