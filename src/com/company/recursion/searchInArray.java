package com.company.recursion;

public class searchInArray {
    static void search(int arr[], int index, int target){
        if (index == arr.length){
            System.out.println("element not found");
            return;
        }
        if (arr[index]==target){
            System.out.println(target +" found at index: "+index);
            return;
        }

        search(arr,index+1,target);
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,23,5,2,45,8,2,9,6,44,2};
        int target = 443;
        search(arr,0,target);
    }
}
