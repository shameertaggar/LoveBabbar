package com.company.stacks;

import java.util.Stack;


public class nextSmallerElement {
    static void nextSmaller(int arr[],int size){
         Stack<Integer> s = new Stack<>();
         s.push(-1);

         for (int i = size-1; i>=0 ; i--){
             int curr = arr[i];
             while (s.peek() >= curr){
                 s.pop();
             }
              arr[i] = s.peek();
             s.push(curr);
         }
    }
    public static void main(String[] args) {
        int arr[] = {8,4,6,2,3};

        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        int n = arr.length;

        nextSmaller(arr,n);
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}
