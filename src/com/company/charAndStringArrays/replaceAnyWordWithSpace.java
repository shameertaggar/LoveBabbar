package com.company.charAndStringArrays;

public class replaceAnyWordWithSpace {
    public static void main(String[] args) {
        String name = "My name is shameer";
        char arr[] = name.toCharArray();

        for (int i = 0; i<arr.length ; i++){
            if (arr[i] == 'a'){
                arr[i] = ' ';
            }
        }

        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
