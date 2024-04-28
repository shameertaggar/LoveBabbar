package com.company.recursion;

public class sumOfNTerms {

    static int sum(int n){
        if (n==0){
            return 0;
        }
        int ans = n + sum(n-1);
        return ans;
    }

    public static void main(String[] args) {
        int ans  = sum(10);
        System.out.println(ans);
    }
}
