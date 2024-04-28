package com.company.charAndStringArrays;

public class convertToUpperCase {
    public static void main(String[] args) {
        String ab = "shameer";
        char arr[] = ab.toCharArray();
        char a = 'a';
        System.out.println("Before");
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        for (int i = 0; i<arr.length; i++){
            arr[i] = (char) (arr[i] - 'a' + 'A');
        }
        System.out.println("After");
        for (int i =0; i<arr.length; i++){
            System.out.print( arr[i] );
        }
        System.out.println();
    }
}
