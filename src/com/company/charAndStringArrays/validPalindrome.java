package com.company.charAndStringArrays;

public class validPalindrome {
    public static void main(String[] args) {
        String str = "abca";
        int i = 0;
        int j = str.length()-1;


        while (i < j){

            if (str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{

                // incresed 1 by i+1 for removing element similarly deceased j for removing j
                boolean ans1 = checkPalindrom(str,i+1,j);
                boolean ans2 = checkPalindrom(str,i,j-1);
                System.out.println(ans1 || ans2);
                break;
            }

        }

        System.out.println("String is palindrome");

    }

    private static boolean checkPalindrom(String str, int i, int j) {


        while (i <= j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
