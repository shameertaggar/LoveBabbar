package com.company.arrays;

import java.util.Arrays;

public class twoSum {
    public static void main(String[] args) {
        int arr[] = {3,5,3,5,23,5,1,9,3,42,2,8,4,1,3};
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int target = 10;
 // 1 2 3 4 5 6 7 8
        Arrays.sort(arr);

        for (int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        while(s < e) {

            int q = arr[s] + arr[e];

            if (q == target){
                System.out.println("pair is " + arr[s] +","+arr[e] + "  where s:"+s+"  e:"+e );
                s++;
                e--;
            }else if (q < target){
                s++;
            }
            else if (q > target){
                e--;
            }
        }


        }
    }

