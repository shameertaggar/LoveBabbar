package com.company.charAndStringArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class groupAnagrams {
    public static void main(String[] args) {
        String arr[] = {"eat","tea","tan","ate","nat","bat"};
        String sortedArr[] = new String[arr.length];
        ArrayList<ArrayList<String>> anagrams = new ArrayList<>();


        boolean[] processed = new boolean[arr.length];

        for (int i = 0; i< arr.length; i++){
            char a[] = arr[i].toCharArray();
            Arrays.sort(a);
            String str = new String(a);

            sortedArr[i] = str;
        }

        //further optimize it with binary

        for (int i = 0; i < arr.length; i++) {
            if (!processed[i]) {
                System.out.println("Group " + i);
                System.out.println(arr[i]);

                for (int j = 0; j < arr.length; j++) {
                    if (i != j && sortedArr[i].equals(sortedArr[j])) {
                        System.out.println(arr[j]);
                        processed[j] = true;
                    }
                }
                System.out.println();
            }
        }



    }
}
