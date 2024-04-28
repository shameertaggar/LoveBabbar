package com.company.recursion;

public class reverseAString {
    public static void main(String[] args) {
        String str = "Shameer";
        char s[] = str.toCharArray();
        char[] q = new char[s.length];
        reverse(s,0,q);


        str = new String(q);
        System.out.println(str);
    }

    private static void reverse(char[] s, int i,char[] q) {
        if (i==s.length){
            return ;
        }
        reverse(s,i+1,q);
        q[s.length - i-1] = s[i];

    }
}
