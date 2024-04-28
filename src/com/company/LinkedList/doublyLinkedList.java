package com.company.LinkedList;



class DDL{
    Node head;


    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int d){
            data = d;
            next = null;
            prev = null;
        }

    }


    public void insert(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
        }else{
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
    }

    public void print(){
        if (head == null){
            System.out.println("empty list");
        }else{
            Node curr = head;
            while(curr != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    public void insertAtStart(int d){
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
        }else{
            Node curr = head;
            curr.prev = newNode;
            newNode.next = curr;
            head = newNode;
        }
    }

    public void insertAtNthPos(int d,int pos){
        Node newNode = new Node(d);
        Node curr = head;
        while (pos > 1){
            curr = curr.next;
            pos--;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;



    }
}
public class doublyLinkedList {
    public static void main(String[] args) {

        DDL a = new DDL();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.print();
        System.out.println("after inserting at starting");
        a.insertAtStart(9);
        a.print();
        System.out.println("after inserting at Nth position");
        a.insertAtNthPos(5,7);
        a.print();

    }
}
