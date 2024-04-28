package com.company.stacks;

import java.util.Stack;

public class middleElementOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        int n = stack.size();

        System.out.println("size of stack is " + n);
        if (n%2 == 0){
            n = n/2;
        }else{
            n = n/2 + 1;
        }

         findMiddleElement(stack,n);
       // System.out.println(ans);


    }

    private static void findMiddleElement(Stack<Integer> stack, int n) {
        if (n == 1) {
            System.out.println(stack.peek());
            return ;
        }
        n = n-1;
        int a = stack.pop();
        findMiddleElement(stack, n);
        stack.push(a);
        return ;
    }
}
