package com.company.recursion;

public class printIndexOfAllOccurenceOfTargetInArray {
    static void print(int arr[] , int target, int index){
        if (index == arr.length){
            return ;
        }

        if (arr[index] == target){
            System.out.println("Target exist at :"+ index);
        }
        index++;
        print(arr, target, index);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,89,7,5,3,4,3,4,2,3,4,2};
        print(arr,4,0);
    }
}
