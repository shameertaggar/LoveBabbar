package com.company.charAndStringArrays;

public class removeAllOccurrenceOfaSubstring {
    public static void main(String[] args) {
        String str = "abcabcabcabc";
        String subStr = "abc";
        String ans = "";

        for (int i = 0; i<str.length()+1; i++){
            if (ans.length()>3 && ans.substring(ans.length()-3, ans.length() - 0).equals(subStr)){
                ans = ans.substring(0,ans.length()-3);
                if ( i == str.length()){
                    break;
                }
                ans += str.charAt(i);
            }else{
                ans += str.charAt(i);
            }
        }

        if (ans.equals(subStr)){
            ans = "";
        }

        System.out.println("final answer is " + ans);

    }
}
