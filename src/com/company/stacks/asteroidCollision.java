package com.company.stacks;

import java.util.Stack;

public class asteroidCollision {
    public static void main(String[] args) {

        int asteroids[] = {-2,-2,2,-2};
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            st.push(asteroids[i]);
            if (st.peek() < 0){
                if (!st.isEmpty()) {
                    System.out.println("removing");
                    removeSmallAst(st);
                }
            }
        }
        int arr[] = new int[st.size()];
        for (int i = st.size()-1; i>=0; i--){
            arr[i] = st.pop();
            System.out.println(arr[i]);
        }



    }

    private static void removeSmallAst(Stack<Integer> st) {
        int collAst = st.pop();
        int k = 0;
        System.out.println("collision ast : " + collAst);
        if (!st.isEmpty() && st.peek() >= 0){
            while(!st.isEmpty() &&  st.peek() >= 0&&st.peek() <= Math.abs(collAst) && st.peek() != collAst){
                System.out.println("popping");
                 k  = st.pop();
            }
            if (!st.isEmpty() &&  st.peek() == collAst){
                st.push(collAst);
            }

            if (k == Math.abs(collAst)){
                st.pop();
            }

        }else{
            st.push(collAst);
        }

    }
}
