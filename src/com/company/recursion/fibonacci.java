package com.company.recursion;

public class fibonacci {
    static int series(int n){
        if ( n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        int ans = series(n-1)+series(n-2);
        return ans;
    }

    public static void main(String[] args) {
        int ans = series(7);
        System.out.println(ans);
    }
}
