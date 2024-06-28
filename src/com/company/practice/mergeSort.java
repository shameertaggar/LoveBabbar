package com.company.practice;

public class mergeSort {
    public static void main(String[] args) {
        int arr[] = {2,1,8,5,4,0,8,3,9,10,11,2};
        mergeSortSplit(arr,0,arr.length-1);
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void mergeSortSplit(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = (start+end)/2;
        mergeSortSplit(arr,start,mid);
        mergeSortSplit(arr,mid+1,end);

        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int totalLen = end - start + 1;
        int gap = (int) Math.ceil((double) totalLen / 2);

        while(gap > 0){
            System.out.println("gap : " + gap);
            int i = start;
            int j = start+gap;
            while(i<=mid && j <= end){
                if(arr[i] > arr[j]){
                    System.out.println("swapping");
                    swap(arr,i,j);

                }
                i++;
                j++;

            }

            gap = findGap(gap);
        }
    }

    private static int findGap(int gap) {
        if(gap <= 1){
            return 0;
        }
        return (int) Math.ceil(gap/2);
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
