package com.company.charAndStringArrays;

import java.util.Arrays;

public class isomorphicStrings {
    //similar to stringCompression just remove the alphabets and compare the number of alphabets

    public static void main(String[] args) {
        String s = "egga";
        String t = "abbd";
        char nS[] = s.toCharArray();
        char nT[] = t.toCharArray();

        Arrays.sort(nS);
        Arrays.sort(nT);

        String qS = "";
        String qT = "";
        int cS = 1;
        int cT = 1;



        for (int i = 1; i<s.length(); i++){
            if (s.length() != t.length()){
                System.out.println("Lengths does not match");
                return ;
            }

            if (nS[i-1] == nS[i]){
                cS++;
                qS = qS + Integer.toString(cS);
            }else{
                cS = 1;
                qS = qS + Integer.toString(cS);

            }

            if (nT[i-1] == nT[i]){
                cT++;
                qT = qT + Integer.toString(cT);
            }else{
                cT = 1;
                qT = qT + Integer.toString(cT);

            }
        }


        char eS[] = qS.toCharArray();
        char eT[] = qT.toCharArray();

        Arrays.sort(eT);
        Arrays.sort(eS);

        qS = new String(eS);
        qT = new String(eT);

        System.out.println("qS " + qS);
        System.out.println("qT "+ qT);


        if (qS.equals(qT)){
            System.out.println(s+" & "+t+" are isomorphic strings");
        }else{
            System.out.println(s+" & "+t+" are non-isomorphic strings");
        }
    }

}
