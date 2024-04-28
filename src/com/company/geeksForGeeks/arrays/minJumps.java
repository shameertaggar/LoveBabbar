package com.company.geeksForGeeks.arrays;

// do it again on geeksForGeeks

public class minJumps {
    public static void main(String[] args) {
        int arr[] = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};

        int n = arr.length;
        int index = 0;
        int c = 0;

        if(arr[0] == 0 || n <= 1){
            System.out.println("Unable to jump");
            return;
        }

        while(index < n){
            if (arr[index] == 0){
                System.out.println("Unable to jump");
                return;
            }
            if (index == arr.length-1){
                System.out.println(c);
            }
            c++;
            index = index + arr[index];

        }

        System.out.println(c);
    }
}
