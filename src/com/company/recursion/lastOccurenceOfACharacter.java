package com.company.recursion;

public class lastOccurenceOfACharacter {

    static void lastOcc(char s[],int index,char target,int last){
        if ( index < s.length && s[index] == target){
             last = index ;
        }

        if (index == s.length){
            System.out.println(last);
            return ;
        }


        lastOcc(s,index+1,target,last);
    }
    public static void main(String[] args) {
        String str = "abcad";
        char s[] = str.toCharArray();

       lastOcc(s,0,'a',-1);



    }
}
