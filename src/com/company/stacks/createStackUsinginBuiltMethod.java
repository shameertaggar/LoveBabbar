package com.company.stacks;

import java.util.Stack;

public class createStackUsinginBuiltMethod {

    static void stackPush(Stack <Integer> stack){

    }

    static void stackPop(Stack<Integer> stack){

    }

    static void stackPeek(Stack<Integer> stack){

    }

    static void stackSearch(Stack <Integer> stack){

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println("Top of the Stack is : "+stack.peek());
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("printing stack : "+ stack);
        stack.pop();

        System.out.println("printin stack after pop : "+ stack);

        System.out.println("searching element 2 :" + stack.search(2));

    }
}
