package com.company.recursion;

public class subSequencesOfAString {
    static String sequence(char[] str, String output, int index){

        if (index== str.length){
            System.out.println(output);
            return output;
        }

        sequence(str,output + str[index],index+1);
        sequence(str,output+"",index+1);

        return output;
    }

    public static void main(String[] args) {
        String string = "abc";

        char str[] = string.toCharArray();

        sequence(str,"",0);
    }
}
