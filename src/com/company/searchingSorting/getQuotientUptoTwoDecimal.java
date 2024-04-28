package com.company.searchingSorting;

public class getQuotientUptoTwoDecimal {
    public static void main(String[] args) {

        int dividend = 38;
        int divisor = 10;

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
        r = divisor*ans;
        double q = (double)(dividend-r)/divisor;
        double a = (double)(q+ans);
        System.out.println(a);


    }
}
