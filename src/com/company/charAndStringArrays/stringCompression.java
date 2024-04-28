package com.company.charAndStringArrays;

public class stringCompression {
    public static void main(String[] args) {
        String str[] = {"a","b","b","b","b","b","b","b","b","b","b","b","b"};
        String qNew = "";
        int count = 1;
        for (int i = 1; i<str.length; i++){
            if(str[i-1] == str[i]){
                count++;
                if (i == str.length-1){
                    qNew = qNew = qNew + str[i-1] + Integer.toString(count);
                    break;
                }
            }
            if(count == 1){
                qNew = qNew + str[i-1] ;
                continue;
            }
            if (str[i-1] != str[i]){
                qNew = qNew + str[i-1] + Integer.toString(count);
                count = 1;
                if (i == str.length-1 && count != 1){
                    qNew = qNew = qNew + str[i-1] + Integer.toString(count);
                    break;
                }



            }
        }

        System.out.println(qNew);
    }
}
