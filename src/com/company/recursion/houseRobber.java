package com.company.recursion;

public class houseRobber {
    static int rob(int[] arr, int index, int size){
        if (index >= size){
            return 0;
        }

       int option1  = arr[index]  + rob(arr, index + 2, size);
       int option2 = 0 + rob(arr, index + 1, size);

       return Math.max(option1,option2);
    }
    public static void main(String[] args) {
      //  int arr[] = {3,5,2,4,7,3,4,3,4,3,3};

        int arr[] = {1,2,3,1};

        int ans = rob(arr,0,arr.length);
        System.out.println(ans);
    }
}
