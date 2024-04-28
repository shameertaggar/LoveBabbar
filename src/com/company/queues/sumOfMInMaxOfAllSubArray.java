package com.company.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class sumOfMInMaxOfAllSubArray {
    public static void main(String[] args) {
        int arr[] = {1, 5, 6, 7, 8, 10, 6, 5, 6};
        int k = 7;

        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();


        for (int i = 0;i<k; i++){
            int e = arr[i];
            while (!max.isEmpty() && e > arr[max.peekLast()]){
                max.removeLast();
            }
            max.addLast(i);
            while (!min.isEmpty() && e < arr[min.peekLast()]){
                min.removeLast();
            }
            min.addLast(i);
        }



        // processing remaining array
        for (int i = k ; i<arr.length; i++){
            int sum = arr[max.peek()]+arr[min.peek()];
            System.out.println("Sum of min " +arr[max.peek()] +" max " + arr[min.peek()] +"  = " + sum);

            // out of range removal for maximum
            if (!max.isEmpty() && (i - max.peek()) >= k){
                System.out.println("removing " + max.peek());
                max.removeFirst();
            }

            // out of range removal for minimum
            if (!min.isEmpty() && (i - min.peek()) >= k){
                System.out.println("removing " + min.peek());
                min.removeFirst();
            }

            int e = arr[i];
            //addition operation in queue max
            while (!max.isEmpty() && e >= arr[max.peek()]){
                max.removeLast();
            }
            max.addLast(i);

            // adition operation in queue min
            System.out.println(min);
            while (!min.isEmpty() && e <= arr[min.peek()]){
                System.out.println("removing : "+min.remove());

            }
            min.addLast(i);

        }

        int sum = arr[max.peek()]+arr[min.peek()];
        System.out.println("Sum of min " +arr[max.peek()] +" max " + arr[min.peek()] +"  = " + sum);

    }
}
