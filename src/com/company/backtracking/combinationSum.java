package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class combinationSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();
        int arr[] = {4,5,3,7};
        int target = 7;
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

            v.add(arr[i]);
            sum(arr, i, target - arr[i], v, ans);
            v.remove(v.size() - 1);
        }



    }
}
