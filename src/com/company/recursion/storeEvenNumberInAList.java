package com.company.recursion;

import java.util.ArrayList;

public class storeEvenNumberInAList {


    public static void main(String[] args) {
        int arr[] = {1,2,4,3,5,67,8,9,10,11,12,13,14,15,16,17,18,19,21,32,43,54,65,76,87,98};
        ArrayList<Integer> evenNum = new ArrayList<Integer>();
        findEven(arr,0,evenNum);


        System.out.println("created array list");
        for (int i = 0; i<evenNum.size(); i++){
            System.out.println(evenNum.get(i));
        }
    }

    private static void findEven(int[] arr, int i, ArrayList<Integer> evenNum) {

        if (i >= arr.length){
            return;
        }
        if (arr[i]%2 == 0){
            evenNum.add(arr[i]);
        }
        findEven(arr,i+1,evenNum);




    }
}
