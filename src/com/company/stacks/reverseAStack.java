package com.company.stacks;

import java.util.Stack;

// method 1 = using two stacks
// method 2 = using recursion
public class reverseAStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);

        System.out.println("before reversal :" + s.toString());
        reverseStack(s);
        String a = s.toString();
        System.out.println(a);

    }

    private static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        insertBottom(s,top);

        return;
    }

    private static void insertBottom(Stack<Integer> s, int q) {
        if (s.isEmpty()){
            s.push(q);
            return;
        }
        int a = s.pop();
        insertBottom(s,q);
        s.push(a);
        return;
    }
}
