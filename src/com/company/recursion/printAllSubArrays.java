package com.company.recursion;

public class printAllSubArrays {
    static void print(int arr[] , int start, int end){

        if (start > end){
            return;
        }
        if (end < arr.length){
            for (int i = start; i <= end; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            if (end < arr.length-1){
                print(arr,start,end+1);
            }
            if (end == arr.length-1){
                print(arr,start+1,start+1);
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        print(arr,0,0);
    }


}
