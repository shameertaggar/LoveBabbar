package com.company.recursion;

public class palindromeCheck {
    static void check(char s[], int start , int end){

        if (start > end){
            System.out.println("Its a Palindrome");
            return;
        }
        if (s[start] == s[end]){
            check(s,start+1,end-1);
        }else {
            System.out.println("Not a Palindrome");
            return;
        }
    }

    public static void main(String[] args) {
        String str = "racsecar";

        char s[] = str.toCharArray();

        check(s,0,s.length-1);
    }
}
