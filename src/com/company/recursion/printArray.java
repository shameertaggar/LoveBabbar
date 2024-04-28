package com.company.recursion;

public class printArray {

    static void print(int arr[] , int size, int index){
        if (index == arr.length){
            return ;
        }

        System.out.println(arr[index]);
        index++;
        print(arr, size, index);


    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};

        print(arr,arr.length,0);
    }
}
