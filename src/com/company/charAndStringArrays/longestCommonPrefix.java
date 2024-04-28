package com.company.charAndStringArrays;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String str[] = {"flower","flow","flight"};


        String a = "";
        char commonPrefix[] = str[0].toCharArray();


        for (int i = 0; i< str.length; i++){
            char w[] = str[i].toCharArray();
            int minLength = Math.min(commonPrefix.length, w.length);
            int j ;
            for ( j = 0; j<minLength;j++){
                if (commonPrefix[j] != w[j]){
                    break;
                }
            }

            if (j == 0){
                break;
            }
            char[] newCommonPrefix = new char[j];
            System.arraycopy(commonPrefix, 0, newCommonPrefix, 0, j);

            commonPrefix = newCommonPrefix;

        }

        String result = new String(commonPrefix);
        System.out.println("Common Prefix: " + result);

    }
}
