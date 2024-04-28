package com.company.stacks;


class StackLinkList{
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

    public void isEmpty(){
        if (head==null){
            System.out.println("stack is empty");
        }else{
            System.out.println("elements are present");
        }
    }

    public void push(int x){
        Node newNode = new Node(x);
        if (head == null){
            System.out.println("element " + x + " has been pushed to stack");
            head = newNode;
        }else{
            Node curr = head;
            head = newNode;
            head.next = curr;
            System.out.println("element " + x + " has been pushed to stack");
        }
    }

    public void peek(){
        System.out.println(head.data+ " is the top element in stack");
    }

    public void pop(){
        if (head == null){
            System.out.println("stack Underflow");
        }
        else{
            Node curr = head;
            System.out.println("element " + head.data+ " has been deleted");
            head = curr.next;
        }
    }

    public void print(){
        Node curr = head;
        System.out.println("printing stack");
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
public class stackUsingLinkedList {


    public static void main(String[] args) {
        StackLinkList s = new StackLinkList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.print();
        s.pop();
        s.print();
        s.pop();
        s.pop();
        s.print();
        s.peek();
        s.isEmpty();
    }
}
