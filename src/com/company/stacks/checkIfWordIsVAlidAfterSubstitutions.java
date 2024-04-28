package com.company.stacks;

import java.util.Stack;

public class checkIfWordIsVAlidAfterSubstitutions {
    public static void main(String[] args) {
        String q = "abcabcababcc";
        Stack<Character> s = new Stack<>();
        if (q.charAt(0) != 'a') {
            System.out.println("Not a Valid String");
            return;
        }
        for (int i = 0; i < q.length(); i++){
            char w = q.charAt(i);
            if (w == 'a'){
                s.push(w);
            }
            else if (w == 'b'){
                if (!s.isEmpty() && s.peek() == 'a'){
                    s.push(w);
                }else{
                    System.out.println("Not a Valid String");
                    return;
                }
            }else{
                if (!s.isEmpty() && s.peek() == 'b'){
                    s.pop();
                    if (!s.isEmpty() && s.peek() == 'a'){
                        s.pop();
                    }else{
                        System.out.println("Not a Valid String");
                        return;
                    }
                }else{
                    System.out.println("Not a Valid String");
                    return;
                }
            }

        }

        if (s.isEmpty()){
            System.out.println("Its A Valid String");
        }
    }
}
