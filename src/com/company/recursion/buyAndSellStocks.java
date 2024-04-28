package com.company.recursion;

import org.omg.CORBA.MARSHAL;

public class buyAndSellStocks {
    static int price(int arr[], int index, int maxProfit,int minPrice, int maxPrice){
        if (index == arr.length){
            return maxPrice;
        }


        if (arr[index] < minPrice){
            minPrice = arr[index];
        }

        if ((arr[index] - minPrice) > maxPrice){
            maxPrice = arr[index] - minPrice;
        }



       return price(arr,index+1,maxProfit,minPrice,maxPrice);
    }

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;

        int max = 0;
        int ans =   price(arr,0,max,minPrice,maxPrice);


        System.out.println(ans);
    }
}
