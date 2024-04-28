package com.company.searchingSorting;

public class BinarySearchOnNearlySortedArray {
    public static void main(String[] args) {
        int arr[] = {20,10,30,50,40,70,60};
        int n = arr.length;
        int target = 20;
         int ans = searchArr(arr,target);
        System.out.println("Found at index "+ ans);
    }

    private static int searchArr(int[] arr, int target) {
        int ans = -1;
        int n = arr.length;
        int s = 0;
        int mid = (s+n)/2;

        while (s <= n){
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid-1] == target){
                return mid-1;
            }
            if (arr[mid+1] == target){
                return mid+1;
            }
            if (arr[mid]>target){
                n = mid - 2;
            }
            else{
                s = mid+2;
            }
            mid = (n+s)/2;
        }
        return ans;
    }
}
