package com.company.stacks;


import java.sql.SQLOutput;

class stack{
    static final int max = 10;
    int top;
    int a[] = new int[max];
    stack(){
        top = -1;
    }

    boolean isEmpty(){
        return (top<0);
    }


    public void push(int x){
        if (top >= max-1){
            System.out.println("Stack overflow");
        }else{
            top++;
            System.out.println("element " + x+ " has been inserted");
            a[top] = x;

        }

    }

    public void pop(){
        if (top < 0){
            System.out.println("Stack uderflow");
        }else{
            System.out.println("element " + a[top] + " has been popped ");
            top--;
        }
    }

    public void peek(){
        int q = a[top];
        System.out.println("element at top is : "+ q);
    }

    public void print(){
        System.out.println("printing stack");
        for (int i = top; i >-1; i--){
            System.out.println(a[i]);
        }
    }
}
public class stackUsingArray {

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.print();
        s.push(9);
        s.push(10);
        s.push(11);

        s.print();

        s.peek();

        s.pop();
        s.print();
        s.pop();
        s.pop();
        s.print();

    }


}
