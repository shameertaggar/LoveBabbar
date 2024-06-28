package com.company;

public class Main {

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,0,0,1};

        int ans = minOperations(nums);
        System.out.println(ans);
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        boolean flip = false;

        for (int i = 0; i < n; i++) {
            // Check if we need to flip the current element based on the number of previous flips
            if (flip) {
                nums[i] = 1 - nums[i];
            }

            // If the current element is 0, we need to flip the rest of the array starting from here
            if (nums[i] == 0) {
                operations++;
                flip = !flip;
            }
        }

        return operations;

    }


}
 //   int k = n - q;
//           for (int w = 2*k-1; w > 0; w--){
//               if (w%2 == 1){
//                   num2 = num2 + 1;
//                   System.out.print(num2 + " ");
//               }else {
//                   System.out.print("* ");
//               }
//
//           }