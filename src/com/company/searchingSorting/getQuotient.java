package com.company.searchingSorting;

public class getQuotient {
    public static void main(String[] args) {

        int dividend = 38;
        int divisor = 4;

        int s = 0;
        int e = dividend;
        int mid = (s+e)/2;

        int ans = 0;
        int r = divisor*mid;

        while(s<=e){
             r = divisor*mid;
            if (r==dividend){
                System.out.println(mid);
            }
            if (r<dividend){
                ans = mid;
                s = mid+1 ;
            }else{
                e = mid-1;
            }

            mid = (s+e)/2;
        }
        System.out.println(ans);


    }


}
