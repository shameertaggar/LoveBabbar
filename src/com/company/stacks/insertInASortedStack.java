package com.company.stacks;

import java.util.Stack;

public class insertInASortedStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(10);
        s.push(9);
        s.push(7);
        s.push(5);
        s.push(3);
        s.push(2);
        s.push(1);

        System.out.println("before insertion : " + s.toString());
        insert(s,12);

        System.out.println("after insertion : " + s.toString());
    }

    private static void insert(Stack<Integer> s, int i) {
        if (s.isEmpty()){
            s.push(i);
            return;
        }
        int a;
        if (s.peek() < i){
             a = s.pop();

        }else{
            s.push(i);
            return;
        }
        insert(s,i);
        s.push(a);
        return;

    }

}
