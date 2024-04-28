package com.company.stacks;

import java.net.Inet4Address;
import java.util.Stack;

public class sortAStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(4);
        s.push(2);
        s.push(6);
        s.push(7);
        s.push(5);
        s.push(3);
        s.push(1);
        s.push(10);

        System.out.println("before sorting : " +s.toString());
        sortStack(s);
        System.out.println(s.toString());

    }

    private static void sortStack(Stack<Integer> s) {
        if (s.isEmpty()){
            return;
        }
        int q = s.pop();
        System.out.println("q : " + q);
        sortStack(s);
        insert(s,q);
        System.out.println("inserted");

        return;
    }
    private static void insert(Stack<Integer> s, int i) {
        System.out.println(i);
        if (s.isEmpty()){
            s.push(i);
            return;
        }
        int a;
        if (s.peek() == i){
            return;
        }
        if (s.peek() < i){
            a = s.pop();
        }else{
            s.push(i);
            return;
        }
        insert(s,i);
        s.push(a);
        System.out.println(s.toString());
        return;

    }
}
