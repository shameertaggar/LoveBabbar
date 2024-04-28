package com.company.charAndStringArrays;

public class findLengthOfString {
    public static void main(String[] args) {
        char arr[] =  new char[20];

        arr[0] = 'h';
        arr[1] = 'e';
        arr[2] = 'l';
        arr[3] = 'l';
        arr[4] = 'o';

        int c = 0;


        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
            if (arr[i] == '\0'){
                break;
            }else{
                c++;
            }
        }

        System.out.println("Length of string is " + c);





    }
}
