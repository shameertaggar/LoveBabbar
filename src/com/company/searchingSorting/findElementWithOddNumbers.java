package com.company.searchingSorting;

public class findElementWithOddNumbers {
    public static void main(String[] args) {
        int arr[] = {10,10,2,2,5,5,2,5,5,20,20,11,11,10,10};

        int ans = -1;

        ans = FindElement(arr);
        System.out.println(arr[ans]);
    }

    private static int FindElement(int[] arr) {
        int e = arr.length-1;
        int ans = -1;
        int s = 0;
        int mid = (s+e)/2;

        while (s <= e){
            if (s==e){
                return s;
            }
            if (mid%2 == 0){
                // if this is true it means we have to move to right
                if (arr[mid] == arr[mid+1] && mid+1 < arr.length){
                    s = mid+2;
                }else {
                    ans = mid;
                    e = mid;
                }
            }
            else{
                // if this is true so we have to move to left
                if (mid-1 > 0 && arr[mid] == arr[mid-1]){
                    s = mid+1;
                }else {
                    e = mid-1;
                }
            }

            mid = (s+e)/2;
        }

        return ans;
    }
}
