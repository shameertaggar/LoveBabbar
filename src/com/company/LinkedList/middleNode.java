package com.company.LinkedList;

class middle{
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public void insert(int d){
        Node newNode = new Node(d);
        if (head==null){
            head = newNode;
        }else{
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void print(){
        if (head == null){
            return;
        }
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
    public void middleElement(){
        Node slow = head;
        Node fast = head;
        if (head == null){
            return;
        } else {
            while (fast != null ) {
                fast = fast.next;
                if (fast != null){
                    fast = fast.next;
                    slow = slow.next;
                }

            }
            System.out.println("middle of the linked list is  " + slow.data);
        }
    }

    public void diffMiddleElement(){
        Node slow = head;
        Node fast = head;
        if (head == null){
            return;
        } else {
            while (fast.next != null ) {
                fast = fast.next;
                if (fast.next != null){
                    fast = fast.next;
                    slow = slow.next;
                }

            }
            System.out.println("middle of the linked list is  " + slow.data);
        }
    }

}
public class middleNode {
    public static void main(String[] args) {
        middle a = new middle();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        System.out.println("printing linked list");
        a.print();
        System.out.println();
        System.out.println("printing middle");
        a.middleElement();
        System.out.println("print diff element");
        a.diffMiddleElement();

    }
}
