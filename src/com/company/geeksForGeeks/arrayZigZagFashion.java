package com.company.geeksForGeeks;

public class arrayZigZagFashion {
    public static void main(String[] args) {
        int a[] = {4, 3, 7, 8, 6, 2, 1};
        int n = a.length;

        for (int i = 0; i<n-1 ; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for(int i = 1; i<n-1 ; i= i + 2){
            if(a[i-1] > a[i]){
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
            System.out.println(" after 1st swapping when vale of i =" + i);
            for (int j = 0; j<n ; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println();
            if(a[i] < a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }

            System.out.println(" after 2nd swapping ");
            for (int j = 0; j<n ; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i<n ; i++){
            System.out.print(a[i] + " ");
        }
    }
}
