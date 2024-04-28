package com.company.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class fibbonacci {
    static int calculate(int n){
        if(n==0 || n==1){
            return n;
        }
        int ans = calculate(n-1) + calculate(n-2);
        return ans;
    }
    public static void main(String[] args) {
        int n = 7;
        int ans = calculate(n);
        System.out.println("Answer is : " + ans);

        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));

        ans = solveByDp(n,dp);
        System.out.println("Answer from dp : " + ans);


    }

    private static int solveByDp(int n, ArrayList<Integer> dp) {
        if (n==0 || n==1){
            return n;
        }
        if (dp.get(n) != -1) {
            return dp.get(n);
        }
        int ans = solveByDp(n - 1, dp) + solveByDp(n - 2, dp);

        dp.set(n, ans);

        return ans;

    }
}
