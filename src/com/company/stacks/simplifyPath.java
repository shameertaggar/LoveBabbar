package com.company.stacks;

import java.util.Stack;

public class simplifyPath {
    public static void main(String[] args) {
        String q = "/a/./b/..////../c/../r";

        Stack<Character> s = new Stack<>();
        if (s.isEmpty() && q.charAt(0) != '/'){
            System.out.println("Invalid path");
            return;
        }
        for (int i = 0; i < q.length(); i++){
            if (q.charAt(i) == '.' && s.peek() =='/'){
                s.pop();
            }else if (q.charAt(i)== '.' && s.peek() != '/'){
                s.pop();
                s.pop();
            }
            else{
                if (i==0){
                    s.push(q.charAt(i));
                }else if (i > 0){
                    if (q.charAt(i-1) == '/' && q.charAt(i) == '/' ){
                        continue;
                    }else{
                        s.push(q.charAt(i));
                    }
                }

            }
        }

        System.out.println("final path : " + s.toString());
    }
}
