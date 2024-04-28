package com.company.queues;

import java.util.Stack;

// using two stacks push :

class met{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    void push(int x){

            while(!s1.isEmpty()){
                int q = s1.pop();
                s2.push(q);
            }
            if (s1.isEmpty()){
                System.out.println("element pushed : " + x);
                s1.push(x);
                while (!s2.isEmpty()){
                    int q = s2.pop();
                    s1.push(q);
                }
        }
    }
     void pop(){
        if (s1.isEmpty()){
            System.out.println("Queue is empty");
        }else{
            System.out.println("Popped element : " + s1.pop());
        }
    }

     void front(){
         if (s1.isEmpty()){
             System.out.println("Queue is empty");
         }else{
             System.out.println("Front element : " + s1.peek());
         }
    }

    void rear(){
        while(!s1.isEmpty()){
            int q  = s1.pop();
            s2.push(q);
        }
        if (s1.isEmpty() && !s2.isEmpty()){
            System.out.println("Rear elemnt : " + s2.peek());
        }
        while(!s2.isEmpty()){
            int q  = s2.pop();
            s1.push(q);
        }
    }
}

class method2{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int x){
        s1.push(x);
        System.out.println("element pushed : " + x);
    }
    void pop(){
        if (!s2.isEmpty()){
            int q = s2.pop();
            System.out.println("element popped : " + q);
        }else{
            while(!s1.isEmpty()){
                int q = s1.pop();
                s2.push(q);
            }
            int q = s2.pop();
            System.out.println("element popped : " + q);
        }
    }
    void front(){
        if (!s2.isEmpty()){
            System.out.println("front element : " + s2.peek());
            s2.peek();
        }else{
            while(!s1.isEmpty()){
                int q = s1.pop();
                s2.push(q);
            }
        }
    }

    void rear(){
        if(!s1.isEmpty()){
            System.out.println("rear element : " + s1.peek());
        }else{
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            System.out.println("rear element : " + s1.peek());

        }
    }
}
public class implementUsingStack {

    public static void main(String[] args) {
        met m = new met();
        m.push(1);
        m.push(2);
        m.push(3);
        m.push(4);
        m.push(5);
        m.push(6);
        m.push(7);
        m.pop();
        m.pop();
        m.front();
        m.rear();
        m.pop();
        System.out.println("\n\n");

        method2 m1 = new method2();
        m1.push(1);
        m1.push(2);
        m1.push(3);
        m1.push(4);
        m1.push(5);
        m1.push(6);
        m1.push(7);
        m1.pop();
        m1.push(8);
        m1.pop();
        m1.rear();
        m1.front();




    }
}
