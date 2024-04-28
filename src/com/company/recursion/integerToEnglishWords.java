package com.company.recursion;

import java.util.HashMap;
import java.util.Map;

public class integerToEnglishWords {
    public static void main(String[] args) {
        int a = 241; // two thousand two hundred twenty two
        Map<Integer, String> d = new HashMap<>();
        d.put(0, "Zero");
        d.put(1, "One");
        d.put(2, "Two");
        d.put(3, "Three");
        d.put(4, "Four");
        d.put(5, "Five");
        d.put(6, "Six");
        d.put(7, "Seven");
        d.put(8, "Eight");
        d.put(9, "Nine");
        d.put(10, "Ten");
        d.put(11, "Eleven");
        d.put(12, "Twelve");
        d.put(13, "Thirteen");
        d.put(14, "Fourteen");
        d.put(15, "Fifteen");
        d.put(16, "Sixteen");
        d.put(17, "Seventeen");
        d.put(18, "Eighteen");
        d.put(19, "Nineteen");
        d.put(20, "Twenty");
        d.put(30, "Thirty");
        d.put(40, "Forty");
        d.put(50, "Fifty");
        d.put(60, "Sixty");
        d.put(70, "Seventy");
        d.put(80, "Eighty");
        d.put(90, "Ninety");
        d.put(100, "Hundred");
        d.put(1000, "Thousand");
        d.put(1000000, "Million");
        d.put(1000000000, "Billion");

        System.out.println(a);
        String p = printEnglish(a,"",10,d);
        System.out.println(p);

    }

    private static String printEnglish(int a,String s,int dividee,Map<Integer,String> d) {
        if (a < 21 && a/100 == 0){
            s = s+d.get(a);
            return s;
        }
        if (a > 20 && a < 100){
            int r1 = a%10;
            int r = a/10;
            r = r*10;

            s = s+ d.get(r) + " " +d.get(r1);
            return s;
        }

        if(a == 0){
            return s;
        }

        int rem = a%dividee;
        int ans = a/dividee;
        printEnglish(a,s,10*dividee,d);

        s = s + d.get(rem)+ " "+ d.get(ans);


        return s;
    }




}
