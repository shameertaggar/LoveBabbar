package com.company.backtracking;

public class permutationOfString {

    public static void main(String[] args) {
        String str = "abc";
        permutation(str,0);
    }

    private static void permutation(String str, int i) {
        if (i == str.length()){
            System.out.println(str);
            return;
        }
        int j = i;
        char q[] = str.toCharArray();
        for ( j = i;j< str.length(); j++){
            char a = q[i];
            q[i] = q[j];
            q[j] = a;

            str = new String(q);
            permutation(str,i+1);
        }
    }
}
