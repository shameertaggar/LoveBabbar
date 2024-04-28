package com.company.recursion;

public class powerOfTwo {

    static int power(int n){
        if (n == 0){
            return 1;
        }

        int ans = 2*power(n-1);
        return ans;
    }

    public static void main(String[] args) {
        int ans = power(10);
        System.out.println(ans);
    }
}
