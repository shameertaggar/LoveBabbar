package com.company.arrays;

public class stockBuySell2 {
    public static int stockBuyAndSell(int n, int[] arr) {
        // code here
        int maxProfit = 0;
        int profit = 0;
        int prev = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i] < prev){
                maxProfit = max-min;
                profit = profit + maxProfit;
                System.out.println("profit is " + profit);
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
            if(arr[i] < min){
                min = arr[i];
                System.out.println("min is " + min);
            }
            if(arr[i] > max){
                max = arr[i];
                System.out.println("max is " + max);
            }


            if(i == n-1){
                if(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE){
                    maxProfit = max-min;
                    profit = profit + maxProfit;
                    System.out.println("profit is " + profit);
                }
            }
            prev = arr[i];
        }

        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {3,4,1,5};
        int n =4;
        int ans  = stockBuyAndSell(n,arr);
        System.out.println("Maximum profit is "  + ans);
    }
}
