package com.company.charAndStringArrays;

public class reverseVowelsOfaString {
    public static void main(String[] args) {
        String str = "leetcode";
        char q[] = str.toCharArray();
        String qNew = "";

        for (int i = 0; i< q.length; i++){
            if (q[i] == 'a' || q[i] == 'e' ||q[i] == 'i' ||q[i] == 'o' ||q[i] == 'u' ){
                qNew = qNew + q[i];
            }
        }

        char q1[] = qNew.toCharArray();
        int s = 0;
        int t = q1.length-1;
        for (int i = 0; i< q1.length/2; i++){
            char temp = q1[s];
            q1[s] = q1[t];
            q1[t] = temp;
            s++;
            t--;
        }
        int c = 0;
        for (int i = 0; i< q.length; i++){
            if (q[i] == 'a' || q[i] == 'e' ||q[i] == 'i' ||q[i] == 'o' ||q[i] == 'u' ){

                q[i] = q1[c];
                c++;

            }
        }

        String w = new String(q);
        System.out.println(w);


    }
}
