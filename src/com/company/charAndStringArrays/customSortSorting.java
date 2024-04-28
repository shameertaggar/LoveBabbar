package com.company.charAndStringArrays;

import java.util.Arrays;
import java.util.Comparator;

public class customSortSorting{

    public static void main(String[] args) {
        String str = "abcd";
        String custom = " cba";


        int alpha[] = new int[26];
        for (int i = 0; i< str.length(); i++){
            alpha[str.charAt(i) -'a']++;
        }

        char letter = 'a';
        int length = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<custom.length(); i++){
            if (alpha[custom.charAt(i) -'a'] >0){
                letter = custom.charAt(i);
            }
        }
    }

}
