package com.company.recursion;

// must remember
public class removeAllOccurencesOFASubstring {
    static String remove(String str, String subStr) {
        int index = str.indexOf(subStr);

        if (index == -1) {
            return str;
        }

        String before = str.substring(0, index);
        String after = str.substring(index + subStr.length());

        return remove(before + after, subStr);
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String sub = "abc";

        String ans = remove(s, sub);

        System.out.println(ans);
    }
}
