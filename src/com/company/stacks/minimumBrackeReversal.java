package com.company.stacks;

import javax.crypto.spec.PSource;
import java.util.Stack;

public class minimumBrackeReversal {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String q = "][][]]][]]";
        for (int i = 0; i < q.length() ; i++){
            if (!s.isEmpty()){
                char w = s.peek();
                if (w == '[' && q.charAt(i) ==']'){
                    s.pop();

                }
                else{
                    s.push(q.charAt(i));
                    System.out.println("pushing = " + q.charAt(i));

                }
            }else{
                s.push(q.charAt(i));
                System.out.println("pushing : " + q.charAt(i));
            }
        }


        int count = 0;
        while (!s.isEmpty()){
            char e = s.pop();
            if (!s.isEmpty()){
                char r = s.pop();

                if (e == r){
                    count++;
                }
                if (e!=r){
                    count+=2;
                }
            }else{
                System.out.println("reversal is not possible");
                return;
            }

        }

        System.out.println("minimum reversal is " + count);

    }

}
