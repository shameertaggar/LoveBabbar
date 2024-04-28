package com.company.charAndStringArrays;

public class reverseString {
    public static void main(String[] args) {
        String name = "My name is shameer";
        char arr[] = name.toCharArray();
        int s = 0;
        int e = arr.length-1;

        System.out.println(name);

        for (int i = 0; i<arr.length/2; i++){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }

        System.out.print("After : ");
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
