package com.company.oaQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxSubArray {
    public static List<Integer> getLargestSubarray(List<Integer> arr, int k) {
        // Lambda expression to define comparison function is_less
        // Using lambda expression in Java for Comparator is not straightforward like C++,
        // so we use a traditional method here.
        int li = 0;
        for (int i = 1; i <= arr.size() - k; ++i) {
            if (isLess(arr, li, i, k)) {
                li = i;
            }
        }

        return arr.subList(li, li + k);
    }

    // Helper method to compare subarrays of length k starting at ai and bi in arr
    private static boolean isLess(List<Integer> arr, int ai, int bi, int k) {
        for (int i = 0; i < k; ++i, ++ai, ++bi) {
            if (arr.get(ai) < arr.get(bi))
                return true;
            if (arr.get(ai) > arr.get(bi))
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(76, 20 ,34 ,500, 66, 1 ,480));

        int k = 4;

        List<Integer> largestSubarray = getLargestSubarray(arr, k);
        System.out.println("Largest Subarray: " + largestSubarray); // Output: [4, 3, 2]
    }
}
