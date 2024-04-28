package com.company.geeksForGeeks.arrays;

public class subArrayWithGivenSum {
    public static void main(String[] args) {
        int arr [] = {1,2,3,7,5};
        int n  = arr.length;
        int target = 12;

        int s = 0;
        int e = 0;
        int sum = 0;

        for (int i = 0; i<n; i++){
            sum = sum + arr[i];
            if (sum > target){
                sum = sum - arr[s];
                s++;
            }
            if (sum == target){
                e = i;
                break;
            }
        }

        System.out.println("subarray is starting with position : " + (s+1) + " \n ending with position : " + (e+1));
    }
}
