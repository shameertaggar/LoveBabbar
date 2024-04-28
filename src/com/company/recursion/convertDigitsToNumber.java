package com.company.recursion;

public class convertDigitsToNumber {
    static void convertt(int arr[], int n , int num){
        if (n==arr.length-1){
            int a = arr[n];
            num = num*10 + a;
            System.out.println(num);
            return;
        }
        int a = arr[n];
         num = num*10 + a;
        //System.out.println(num);
         convertt(arr,n+1,num);
    }
    public static void main(String[] args) {
        int arr[] = {123,4,2,4,2};
        convertt(arr,0, 0);
    }
}


// https://www.linkedin.com/404/