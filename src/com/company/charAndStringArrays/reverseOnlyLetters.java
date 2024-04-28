package com.company.charAndStringArrays;

import java.awt.*;

public class reverseOnlyLetters {
    public static void main(String[] args) {

        String s = "a-bC-dEf-ghIj";
        char rS[] = s.toCharArray();

        String nS = "";
        for (int i = 0; i<s.length(); i++){
            char c = rS[i];
            if (Character.isAlphabetic(c)){
                nS = nS + c;
            }
        }

        char nnS[] = nS.toCharArray();
        int start = 0;
        int end = nS.length()-1;
        for (int i = 0; i<nS.length()/2; i++){
            char temp = nnS[start];
            nnS[start] = nnS[end];
            nnS[end] = temp;
            start++;
            end--;
        }
        int index = 0;
        for(int i = 0; i<rS.length; i++){
            char c = rS[i];
            if (Character.isAlphabetic(c)){
                rS[i] = nnS[index];
                index++;
            }
        }

        s = new String(rS);
        System.out.println(s);
    }
}
