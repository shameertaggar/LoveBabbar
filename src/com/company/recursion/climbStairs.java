package com.company.recursion;

public class climbStairs {
    static int climb(int n ){
        if ( n == 0){
            return 1;
        }
        if (n ==1){
            return 1;
        }

        int ans = climb(n-1) + climb(n-2) ;
        return ans;
    }

    public static void main(String[] args) {
        int ans = climb(2);
        System.out.println(ans);
    }
}
