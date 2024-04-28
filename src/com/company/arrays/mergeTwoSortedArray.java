package com.company.arrays;

public class mergeTwoSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,3,4,6,8};
        int arr2[] = {2,4,5,7,9};
        int combined[] = new int[arr.length+arr2.length];
        int q = 0;
        int w = 0;
        for (int i = 0; i< combined.length; i++){
            System.out.println("loop " + i);
            if (i == combined.length-1){
                int e = Math.min(q,w);
                combined[i] = arr2[e];
                break;
            }
            if (arr[q]<arr2[w] && q < arr.length && w <arr2.length){
                combined[i] = arr[q];
                q++;
                System.out.println(combined[i]);
            } else if (arr2[w] <= arr[q] && w <arr2.length && q < arr.length ){
                combined[i] =arr2[w];
                w++;
                System.out.println(combined[i] + "r");
            }
        }

        for (int i = 0; i<combined.length ; i++){
            System.out.print(combined[i] +" ");
        }

    }
}
