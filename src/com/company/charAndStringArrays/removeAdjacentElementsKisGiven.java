package com.company.charAndStringArrays;


// here k means that
public class removeAdjacentElementsKisGiven {

    public static void main(String[] args) {
        String name = "thiss iis myy naame iss shaaameer";
        String ans = "";
        char arr[] = name.toCharArray();
        int k = 2;

        for (int i =0; i< arr.length; i++){
            if (ans.length()>1 && ans.charAt(ans.length()-k) == name.charAt(i)  ){

                ans = ans.substring(0, ans.length() - k);
                System.out.println("anse is "  +ans);
            }
            else{
                ans += name.charAt(i);
            }
        }

        System.out.println(ans);
    }
}
