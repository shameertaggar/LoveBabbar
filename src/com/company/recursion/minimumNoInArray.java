package com.company.recursion;

public class minimumNoInArray {
    static void min(int arr[],int min,int n){
        if (arr[n] < min){
            min = arr[n];
        }
        if (n == 0){
            System.out.println(min);
            return;
        }
        min(arr,min,n-1);
        return ;

    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int arr [] = {193,54,32,87,3276,42,674,67,4,89,23,76,29};

        min(arr,max,arr.length-1);
    }
}
