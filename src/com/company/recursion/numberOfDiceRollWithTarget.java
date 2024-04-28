package com.company.recursion;

public class numberOfDiceRollWithTarget {
    public static void main(String[] args) {
        int k = 3;
        int target = 3;
        int n = 2;

        int ways = numOfWays(n, k, target);
        System.out.println(ways);
    }

    private static int numOfWays(int n, int k, int target) {
        if (n == 0) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        int ways = 0;
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0) {
                ways += numOfWays(n - 1, k, target - i);
            }
        }
        return ways;
    }
}
