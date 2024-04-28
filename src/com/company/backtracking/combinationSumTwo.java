package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class combinationSumTwo {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();
        int arr[] = {2,1,2,2,5,6};
        int target = 5;
        Arrays.sort(arr);
        sum(arr, 0, target, v, ans);
    }

    private static void sum(int[] arr, int index, int target, ArrayList<Integer> v, ArrayList<ArrayList<Integer>> ans) {
        if (target == 0) {
            String a = new String(v.toString());
            System.out.println(a);
            System.out.println();
            return;
        }

        if (target < 0 || index == arr.length) {
            return;
        }



        for (int i = index; i<arr.length; i++ ){
            // Include the current element in the combination
            if (i>index && arr[i] == arr[i-1]){
                continue;
            }
            v.add(arr[i]);
            sum(arr, i+1, target - arr[i], v, ans);
            // Exclude the current element from the combination
            v.remove(v.size() - 1);
        }



    }
}
