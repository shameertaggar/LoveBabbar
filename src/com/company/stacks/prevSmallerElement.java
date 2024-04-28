package com.company.stacks;

import java.util.Stack;

public class prevSmallerElement {
    public static void main(String[] args) {
        int arr[] = {8,4,6,2,3};

        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        int n = arr.length;

        prevSmaller(arr,n);
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void prevSmaller(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for (int i = 0; i< arr.length; i++){
            int curr = arr[i];
            while (s.peek() > curr){
                s.pop();
            }
            arr[i] = s.peek();
            s.push(curr);
        }
    }

}
