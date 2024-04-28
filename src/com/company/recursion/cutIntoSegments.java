package com.company.recursion;

public class cutIntoSegments {
    static int cut(int n, int x, int y, int z){


        if (n==0){
            return 0;
        }
        if(n<0){
            return 0;
        }

        System.out.println("finding answer");
        int a = 1+cut(n-x,x,y,z);
        int b = 1+cut(n-y,x,y,z);
        int c = 1 + cut(n-y,x,y,z);

         int ans = Math.max(a,Math.max(b,c));
        return ans;
    }

    public static void main(String[] args) {
       int ans =  cut(10,2,1,1);
        System.out.println(ans);
    }
}
