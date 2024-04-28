package com.company.recursion;

public class perfectSquares {
    static int perfect(int n, int i, int c, int max){


        if (n == 0){
            if (c < max){
                max = c;
                System.out.println("  value of max is  "+ max);
            }
            return max;
        }

        int squareNum = i*i;
        int j = i;
        if (squareNum <= n){
            c++;
                System.out.print(j + " ");
                perfect(n-squareNum, i,c,max);
        }else {
            perfect(n,i-1,c,max);
        }

        return c;
    }

    public static void main(String[] args) {
        int n = 12;
        int nSmaller = 0;
        int i  = 1;

        while(nSmaller < n){
            i = i + 1;
            nSmaller = i*i;
        }

        int max = Integer.MAX_VALUE;
        i = i - 1;
        int c = 0;
        for (int j = 0; j < i; j++){
            c =  perfect( n ,  i-j, 0, max);
            max = Math.min(c,max);
            System.out.println(max);
        }



    }
}
