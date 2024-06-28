package com.company.searchingSorting;

public class mergeSort {
    public static void main(String[] args) {
      //  int arr[] = {2,4,54,1,3,7,53,12,34,7,9,10,3,5,6,9,1,2,7,8};
        int arr[] = {3,5,6,9,1,2,7,8,1};

        int c = 0;

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        // first we define sort function which divides array from their midpoint
       c =  arrSplit(arr,0,arr.length-1);
        System.out.println("sorted array \n");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("inversions : " + c);

    }

    private static int arrSplit(int[] arr, int s, int e) {
        int c = 0;
        if(s<e){
            int m = s+ (e-s)/2;

            // split from mid
            c += arrSplit(arr,s,m);
            c += arrSplit(arr,m+1,e);

            c += merge(arr,s,m,e);
        }
        return c;
    }

    private static int merge(int[] arr, int s, int m, int e) {
        int c = 0;
        int size1 = m-s+1;
        int size2 = e-m;

        int left[] = new int[size1];
        int right[] = new int[size2];

        for(int i = 0; i<size1;i++){
            left[i] = arr[s+i];
        }
        for(int i = 0; i<size2; i++){
            right[i] = arr[m+1+i];
        }

        // now merge two sorted arrays
        int i = 0;
        int j = 0;
        int k = s;
        while (i<size1 && j<size2){
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                c =+ size1-i;
                //left[i],left[i+1],left[i+2] > right[j]
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < size1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < size2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return c;
        }

}
