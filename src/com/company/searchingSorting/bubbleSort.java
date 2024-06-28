package com.company.searchingSorting;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = {1,6,2,7,23,3,8,5};

        for (int i = 0; i<arr.length; i++){
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }


    }
}
