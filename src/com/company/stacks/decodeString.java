package com.company.stacks;

import java.util.Stack;

// do it again
public class decodeString {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String q = "3[a]2[bc]";
        for (int i = 0 ; i < q.length(); i++){
            if (q.charAt(i) == ']'){
                String temp = "";
                while (!s.isEmpty() && Character.isDigit(s.peek())){

                }
            }else if (q.charAt(i) != '['){
                s.push(q.charAt(i));
            }
        }
    }
}
