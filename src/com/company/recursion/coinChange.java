package com.company.recursion;


// do this question again

public class coinChange {
    public static void main(String[] args) {
        int arr[] = {6,3,5};
        int target = 11;

       int ans = findChange(arr,target);
        if(ans == Integer.MAX_VALUE){
            System.out.println("not answer");
        }else{
            System.out.println(ans);
        }

    }

    private static int  findChange(int[] arr, int target) {

        if (target == 0){
            return 0;
        }

        int c = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
                int recAns = 0;
                if (target-arr[i]>=0){
                    recAns = findChange(arr,target-arr[i]);
                    if (recAns != Integer.MAX_VALUE){
                        int ans = recAns + 1;
                        c = Math.min(ans,c);
                    }

                }

        }
        return c;


    }
}
// if (target == 0){
//            return 0;
//        }
//
//        int c = Integer.MAX_VALUE;
//        for (int i = 0; i < arr.length; i++){
//            int coin  = arr[i];
//
//            if (coin <= target){
//                int recAns = findChange(arr,target-coin);
//
//                if (recAns != Integer.MAX_VALUE){
//                    int ans = 1+recAns;
//                    c = Math.min(c,ans);
//                }
//
//            }
//        }
//return c;