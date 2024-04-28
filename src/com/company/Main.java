package com.company;

public class Main {

    public static void main(String[] args) {

        //use Math.abs() for sending positive values after that assign sign by checking signs of dividend and divisor

        int divisor = -7;
        int dividend = 29;

        int ans = getQuotient(Math.abs(dividend),Math.abs(divisor));

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            ans = 0-ans;
        }
        System.out.println("answer is " + ans);

    }

    private static int getQuotient(int dividend, int divisor) {

        int s = 0;
        int e = dividend;
        int mid = s + (e-s)/2;
        int quotient = -1;

        while(s<=e) {
            if (mid * divisor == dividend) {
                return mid;
            }if (mid * divisor < dividend) {
                quotient = mid;
                s = mid + 1;
            }else  {
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
       return quotient;
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