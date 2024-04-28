package com.company.arrays;

public class pivotIndex {
    public static void main(String[] args) {
        int arr[] = {1,7,3,6,5,6};
        int n = arr.length;
        int a1 = 0;
        int a2 = 0;


        //Brute Force###################################################

        for (int i = 0; i< n;i++){
             a1 = 0;
             a2 = 0;
            for (int q = 0; q <i; q++){
                a1 = a1+arr[q];
            }
            for (int w = i+1; w<n; w++){
                a2 = a2+arr[w];
            }

            if (a1==a2){
                System.out.println("pivot index is " + i);
                break;
            }
        }

    }
}
