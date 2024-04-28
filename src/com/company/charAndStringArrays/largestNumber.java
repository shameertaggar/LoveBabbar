package com.company.charAndStringArrays;

import java.util.Arrays;

public class largestNumber {
    public static void main(String[] args) {

        int nums[] = {3,30,34,5,9};
        Arrays.sort(nums);

        int multiple = 1;
        for (int i = 0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
