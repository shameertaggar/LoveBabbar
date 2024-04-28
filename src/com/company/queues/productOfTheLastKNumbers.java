package com.company.queues;

import java.util.Deque;
import java.util.LinkedList;

public class productOfTheLastKNumbers {

    public static void main(String[] args) {
        int arr[] = {24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39};
        int ans = longestSubarray(arr, 87);
        System.out.println("\n\n\n\n");
        System.out.println("Answer : " + ans);
    }

    static int longestSubarray(int[] arr, int limit) {
        int size = 0;

        for (int k = 1; k <= arr.length; k++) {
            System.out.println("\n\n");
            System.out.println("size  = " + k);

            Deque<Integer> min = new LinkedList<>();
            Deque<Integer> max = new LinkedList<>();

            for (int i = 0; i < k; i++) {
                // Modification: Use index 'i' instead of 'k'
                int e = arr[i];
                while (!max.isEmpty() && e > arr[max.peekLast()]) {
                    max.removeLast();
                }
                max.addLast(i);
                while (!min.isEmpty() && e < arr[min.peekLast()]) {
                    min.removeLast();
                }
                min.addLast(i);
            }

            //{1, 5, 6, 7, 8, 10, 6, 5, 6};
            for (int i = k; i < arr.length; i++) {
                // Modification: Calculate the difference between max and min for the current subarray
                int currentDiff = Math.abs(arr[max.peek()] - arr[min.peek()]);
                System.out.println("diff of max " + arr[max.peek()] + " min " + arr[min.peek()] + "  = " + currentDiff);
                if (currentDiff <= limit) {
                    System.out.println("limit size found : " + k);
                    size = Math.max(size, k);
                }


                if (!max.isEmpty() && (i - max.peek()) >= k) {
                    System.out.println("removing max " + arr[max.peek()]);
                    max.removeFirst();
                }

                System.out.println("minimum  : " + min + " value of  i " + i);
                //minimum removal
                if (!min.isEmpty() && (i - min.peek()) >= k) {
                    System.out.println("removing min " + arr[min.peek()]);
                    min.removeFirst();
                }
                //{1, 5, 6, 7, 8, 10, 6, 5, 6};
                int e = arr[i];
                while (!max.isEmpty() && e >= arr[max.peek()]) {
                    max.removeLast();
                }
                max.addLast(i);

                while (!min.isEmpty() && e <= arr[min.peek()]) {
                    min.removeFirst();
                }
                min.addLast(i);
                System.out.println("minimum  : " + min + " value of  i " + i);
            }
            System.out.println(max);
            System.out.println(min);
            // Modification: Calculate the difference for the last subarray
            int lastDiff = Math.abs(arr[max.peek()] - arr[min.peek()]);
            System.out.println("diff of max " + arr[max.peek()] + " min " + arr[min.peek()] + "  = " + lastDiff);
            if (lastDiff <= limit) {
                System.out.println("limit size found : " + k);
                size = Math.max(size, k);
            }
        }

        return size;
    }
}
