package com.company.recursion;

public class maxNumberinArray {
    static void min(int arr[],int max,int n){
        if (arr[n] > max){
            max = arr[n];
        }
        if (n == 0){
            System.out.println(max);
            return;
        }
        min(arr,max,n-1);
        return ;

    }

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int arr [] = {1,54,32,87,3276,42,674,67,4,89,23,76,29};

        min(arr,max,arr.length-1);
    }
}
