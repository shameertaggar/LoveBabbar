package com.company.recursion;

public class countingToN {

    static void count(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        count(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        count(10);
    }
}
