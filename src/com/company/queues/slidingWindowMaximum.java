package com.company.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,-5,3,6,7};
        int k = 3;
        int max = Integer.MIN_VALUE;
        Deque<Integer > q = new LinkedList<>();

        for (int i = 0; i < k; i++){
            int e = arr[i];
            while (!q.isEmpty() && e > arr[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }

//       {1,3,-1,-3,-5,3,6,7};
        for (int i = k; i < arr.length; i++){
            if (q.isEmpty()){
                System.out.println("Answer : " + 0);
            }else {
                System.out.println("Answer : " + q.peek() + " value of "  + arr[q.peek()]);
            }
            if ( !q.isEmpty() && arr[i] > arr[q.peek()]){
                q.remove();
            }

            // out of range removal
            if (!q.isEmpty() && (i - q.peek()) >= k){
                q.removeFirst();
            }

            int e = arr[i];
            //chotte elements remove krdo
            while (!q.isEmpty() && e > arr[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);

        }

        if (q.isEmpty()){
            System.out.println("Answer : " + 0);
        }else{
            System.out.println("Answer : " + q.peek() + " value of "  + arr[q.peek()]);
        }
    }
}
