package com.company.arrays;

public class rotateArray {
    public static void main(String[] args) {
        int arr[] = { 1,2,3,4,5,6,7,8,9};
        int k = 2;
        int n = arr.length;
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        reverse(arr,0,n-1);
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();


        reverse(arr,0,k-1);
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();


         reverse(arr,k,n-1);
         for (int i = 0; i<arr.length; i++){
             System.out.print(arr[i]+ " ");
         }
        System.out.println();
    }

    private static void reverse(int[] arr, int i, int j) {


        for (int q=0 ; q<j; q++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
}
