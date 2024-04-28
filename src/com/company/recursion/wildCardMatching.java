package com.company.recursion;

public class wildCardMatching {
    public static void main(String[] args) {
        String s = "abcdefir";
        String p = "ab?*f**********ir";

        boolean a = match(s, p, 0, 0);

        System.out.println(a);

    }

    private static boolean match(String s, String p, int sIndex, int pIndex) {



        if (sIndex == s.length() && pIndex == p.length()){
            return true;
        }



        if (s.length()==sIndex && pIndex <p.length()){
            while (pIndex <p.length()){
                if (p.charAt(pIndex)!='*'){
                    return false;
                }
                pIndex++;
            }
            return true;
        }


        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
            return match(s, p, sIndex + 1, pIndex + 1);
        }
        if (p.charAt(pIndex) == '*'){
            // treat * as empty
            boolean case1 = match(s,p,sIndex,pIndex+1 );
            boolean case2 = match(s,p,sIndex+1, pIndex);
            return case1 | case2;
        }


        return false;

    }
}