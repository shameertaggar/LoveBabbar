package com.company.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class distributingRepeatingIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 3};
        int quantity[] = {2, 2, 3};

        // Create a HashMap to count the frequency of integers
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count the frequency of integers in the array
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Create a List to store the counts
        List<Integer> counts = new ArrayList<>();

        // Extract the counts from the countMap and add them to the counts list
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            counts.add(entry.getValue());
        }

      boolean ans =   helper(counts, quantity, 0);
        System.out.println(ans);
    }

    private static boolean helper(List<Integer> counts, int[] quantity, int index) {

        if (index == quantity.length){
            return true;
        }
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) >= quantity[index]) {
                int currentCount = counts.get(i);
                int requestedQuantity = quantity[index];
                counts.set(i, currentCount - requestedQuantity);

                if (helper(counts, quantity, index + 1)) {
                    return true;
                }
                counts.set(i, currentCount + requestedQuantity);
            }
        }

return false;
    }
}