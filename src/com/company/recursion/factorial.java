package com.company.recursion;

public class factorial {

    static int intFactorial(int n){
        if ( n == 0 || n ==1){
            return 1;
        }
        int ans = n * intFactorial(n-1);
        return ans;
    }

    public static void main(String[] args) {

        int fact = intFactorial(5);
        System.out.println(fact);
    }
}
