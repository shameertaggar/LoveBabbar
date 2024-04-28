package com.company.charAndStringArrays;

public class findTheIndexOfaFirstOccurenceInaString {
    public static void main(String[] args) {
        String str = "abc";
        String target = "c";

        String ans = " ";
        if (str.length() < target.length()) {
            System.out.println("not found  :" + "-1" );
        }


        if (target.length() == 1){

            if(str.length() == 1 && target.length()==1){
                if(str.equals(target)){
                    System.out.println("found at index : " + "0");
                }else{
                    System.out.println("not found  :" + "-1" );
                }
            }

            for (int j = 0; j < str.length(); j++){
                char single = str.charAt(j);
                if (single == target.charAt(0)){
                    System.out.println("found at index : " + j);
                }
            }

        }else{

            if (target.length() == str.length()){
                if (str.equals(target)){
                    System.out.println("found at index : " + "0");
                }
            }
            else{
                for (int i = 0; i < str.length()-target.length()+1; i++){
                    ans = str.substring(i,(i+target.length()));

                    if (ans.equals(target)){
                        System.out.println("found at index : " + i);
                        break;
                    }else{
                        System.out.println("not found  :" + "-1" );
                    }
                }
            }

        }



    }
}
