package com.company.charAndStringArrays;

public class countSubstrings {
    public static void main(String[] args) {
        String s = "aaa";

        int count = 0;

        int i = 0;
        int j = 0;

        for (int center = 0; center <s.length(); center++){
            //odd
            int oddAns = exapnd(s,center,center);
            //even
            int evenAns = exapnd(s,center,center+1);

            count = count+oddAns+evenAns;
        }

        System.out.println(count);

    }

    private static int exapnd(String s,int i,int j){

        int count = 0;

        while (i >= 0 && j< s.length() &&s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }

        return count;
    }
}
