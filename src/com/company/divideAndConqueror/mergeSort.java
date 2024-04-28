package com.company.divideAndConqueror;

public class mergeSort {
    public static void main(String[] args) {
        int arr[] = {8,4,2,1};
        int size = 4;
        int s = 0;
        int e = size-1;
        mergeeSort(arr,s,e);

        System.out.println("after merge sort");
        for (int i = 0; i<size; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    private static void mergeeSort(int[] arr, int s, int e) {

        if (s >= e){
            return;
        }

        int mid = (s+e)/2;
        mergeeSort(arr,s,mid);
        mergeeSort(arr,mid+1,e);
        merge(arr,s,e);

    }

    private static void merge(int[] arr, int s, int e) {
        int mid = (s+e)/2;

        int leftLen = mid-s+1;
        int rightLen = e-mid;

        // creating new arrays
        int left[] = new int[leftLen];
        int right[] = new int[rightLen];

        int k  = s;

        //copying elements to left array
        for (int i = 0; i< leftLen; i++){
            left[i] = arr[k];
            k++;
        }

        k = mid+1;
        // copying elements to right array
        for (int i = 0; i<rightLen; i++){
            right[i] = arr[k];
            k++;
        }

        //qctual merge logic
        //left array is already sorted
        //right array is already sorted

        int leftIndex  = 0;
        int rightIndex = 0;

        int mainArrayIndex = s;

        // merging the arrays
        while (leftIndex < leftLen && rightIndex < rightLen){
            if (left[leftIndex] < right[rightIndex]){
                arr[mainArrayIndex] = left[leftIndex];
                mainArrayIndex++;
                leftIndex++;
            }else{
                arr[mainArrayIndex] = right[rightIndex];
                mainArrayIndex++;
                rightIndex++;
            }
        }

        // if left array exhausted then copy all remaining elements of right array to main array
        while (rightIndex < rightLen){
            arr[mainArrayIndex] = right[rightIndex];
            mainArrayIndex++;
            rightIndex++;
        }

        // if right array exhausted then copy all remaining elements of left array to main array

        while (leftIndex < leftLen){
            arr[mainArrayIndex] = left[leftIndex];
            mainArrayIndex++;
            leftIndex++;
        }
        System.out.println("array after merging it becomes");
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
