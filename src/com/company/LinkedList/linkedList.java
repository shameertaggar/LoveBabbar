package com.company.LinkedList;


class linkList{
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }

    }
    public void insert(int data){

        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;

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

    public void insertAtHead(int data){
        Node newNode = new Node(data);

        if (head==null){
          head = newNode;
          return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void  insertAtNthPos(int d, int pos){
        Node newNode = new Node(d);
        Node curr = head;
        while (pos>1){
            curr = curr.next;
            pos--;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }
}


public class linkedList {

    public static void main(String[] args) {

        linkList list = new linkList();
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.print();
        list.insertAtHead(10);
        System.out.println("Printing after insertion");
        list.print();
        list.insertAtNthPos(34,4);
        System.out.println("after inserting at nth position");
        list.print();
    }
}
