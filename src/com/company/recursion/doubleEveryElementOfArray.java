package com.company.recursion;

public class doubleEveryElementOfArray {

    static void doublee(int arr[] , int n){
        if (n == 0){
            int ans = 2*arr[n];
            System.out.println(ans);
            return ;
        }

        doublee(arr,n-1);

        int doub = 2*arr[n];
        System.out.println(doub);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        doublee(arr,arr.length-1);
    }
}
