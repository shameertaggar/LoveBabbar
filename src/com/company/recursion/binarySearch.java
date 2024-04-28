package com.company.recursion;

import java.util.Arrays;

public class binarySearch {
    static int search(int arr[] , int s, int e, int target){

        int mid = (s+e)/2;

        if (arr[mid] == target){
            return mid;
        }

        if (target > arr[mid]){
            s = mid+1;
            return search(arr,s,e,target);
        }
        if (target < arr[mid]){
            e = mid-1;
            return search(arr,s,e,target);
        }
        return -1 ;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        Arrays.sort(arr);
        int ans = search(arr,0,arr.length-1,2);

        System.out.println("answer is index  " +ans);

    }
}
