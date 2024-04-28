package com.company.stacks;

import java.util.Scanner;
import java.util.Stack;

public class bracketIsValid {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String a = "(){}}{";
        if (a.charAt(0) == ')' || a.charAt(0) == ']' || a.charAt(0) == '}'){
            System.out.println("false");
            return;
        }

        for (int i = 0; i< a.length() ; i++){
            char w = a.charAt(i);
            if (a.charAt(i) == '(' || a.charAt(i) == '[' || a.charAt(i) == '{'){
                s.push(a.charAt(i));
            }else{
                if (a.charAt(i) == ')'){
                    if (s.isEmpty()){
                        System.out.println("false");
                        return;
                    }
                    char q = s.peek();
                    if (q == '('){
                        s.pop();
                    }else{
                        System.out.println("false");
                        return;
                    }

                }
                if (a.charAt(i) == ']'){
                    if (s.isEmpty()){
                        System.out.println("false");
                        return;
                    }
                    char q = s.peek();
                    if (q == '['){
                        s.pop();
                    }else{
                        System.out.println("false");
                        return;
                    }
                }
                if (a.charAt(i) == '}'){
                    if (s.isEmpty()){
                        System.out.println("false");
                        return;
                    }
                    char q = s.peek();
                    if (q == '{'){
                        s.pop();
                    }else{
                        System.out.println("false");
                        return;
                    }
                }
            }



        }

        if (s.isEmpty()){
            System.out.println("true");
            return;
        }else{
            System.out.println("false");
            return;
        }
    }
}
