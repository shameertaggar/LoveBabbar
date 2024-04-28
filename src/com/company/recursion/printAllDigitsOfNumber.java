package com.company.recursion;

public class printAllDigitsOfNumber {
    static void print(int num){
        if (num==0){
            return;
        }
        int n = num%10;
        System.out.println(n);
        print(num/10);
    }

    public static void main(String[] args) {
        int n = 67276;
        print(n);
    }
}

