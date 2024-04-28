package com.company.stacks;

import java.util.Stack;

public class removeAllAdjacentDuplicatesInAString {
    public static void main(String[] args) {
        String q = "aabbaca";
        Stack<Character> s = new Stack<>();

        for (int i = 0 ; i< q.length(); i++){
            char w = q.charAt(i);
            if (!s.isEmpty()){
                if (s.peek() == w){
                    s.pop();
                }else{
                    s.push(w);
                }
            }else{
                s.push(w);
            }
        }
        q = s.toString();
        System.out.println("after removing all adjacent : " + q);
    }
}
