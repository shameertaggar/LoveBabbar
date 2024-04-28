package com.company.recursion;

public class checkSorted {
    static int check(int arr[], int n){

        if (n == 0 || n ==1){
            return 1;
        }

        if (arr[n-1] < arr[n-2]){
            return 0;
        }

        return check(arr,n-1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int ans = check(arr,arr.length);
        System.out.println(ans);
    }
}
