package com.company.charAndStringArrays;

public class removeAllAdjacentDuplicatesFromString {
    public static void main(String[] args) {
        String name = "thiss iis myy naame iss shaaameer";
        String ans = "";
        char arr[] = name.toCharArray();

        for (int i =0; i< arr.length-1; i++){
            if (ans.length()>0 && ans.charAt(ans.length()-1) == name.charAt(i)){

                ans = ans.substring(0, ans.length() - 1);
            }
            else{
                ans += name.charAt(i);
            }
        }

        System.out.println(ans);
    }
}
