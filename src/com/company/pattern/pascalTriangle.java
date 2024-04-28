package com.company.pattern;

public class pascalTriangle {
    public static void main(String[] args) {
        int n = 4;
        int a = 1;
        int d = 0;
       // use binomial distribution formula
        for (int i = 0; i<=n; i++){
            for (int j = 0; j<n-i; j++){
                System.out.print(" ");
            }

            for (int j =0; j<i+1; j++){
                int f = factorial(i,j);
                System.out.print(f+" ");
            }
            System.out.println();

        }

    }

    private static int factorial(int n, int j) {
        int c = 1;
        int q = 1;
        int w = 1;
        int r = n-j;

        for (int i = n; i>0; i--){
            c = c*i;
        }
        for (int i = j; i>0; i--){
            q = q*i;
        }
        for (int i = r; i>0; i--){
            w = w*i;
        }


        c = (c)/(q*w);

        return c;

    }
}
