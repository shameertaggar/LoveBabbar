package com.company.stacks;

import java.util.Stack;

public class insertAtBottomOfStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        String a = s.toString();
        System.out.println("Stack : "+a);
        int q = 8;
        insertBottom(s,q);
        String w = s.toString();
        System.out.println("After insertion At bottom Stack : " + w);
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
