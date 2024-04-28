package com.company.charAndStringArrays;

import java.util.Arrays;
import java.util.Locale;

public class validAnagram {
    public static void main(String[] args) {
      String s = "anagram";
      String t = "nagraam";

      char s1[] = s.toCharArray();
      char t1[] = t.toCharArray();

        Arrays.sort(s1);
        System.out.println(s1);
        String s2 = new String(s1);
        Arrays.sort(t1);
        String t2 = new String(t1);
        System.out.println(t1);

        if (s2.equals(t2)){
            System.out.println(s + " & " + t + " are valid anagrams");
        }else{
            System.out.println(s + " & " + t + " are invalid anagrams");
        }
    }
}
