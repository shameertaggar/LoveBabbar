package com.company.LinkedList;

import java.util.Scanner;

class sort{
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

    public Node listMerge(Node head , Node head2){
        Node curr = head;
        Node curr2 = head2;
        Node a = new Node(0);
        Node current = a;
        sort q = new sort();
        while(curr != null && curr2 != null){
            if (curr.data > curr2.data){
               // q.insert(curr2.data);
                current.next = curr2;
                curr2 = curr2.next;
            }else{
                //q.insert(curr.data);
                current.next = curr;
                curr = curr.next;
            }
            current = current.next;
        }

        while (curr != null){
           // q.insert(curr.data);
            current.next = curr;
            curr = curr.next;
        }
        while (curr2 != null){
           // q.insert(curr2.data);
            current.next = curr2;
            curr2 = curr2.next;
        }

        return a.next;
    }
}
public class mergeTwoSortedLists {
    public static void main(String[] args) {
        sort a = new sort();
        a.insert(1);
        a.insert(3);
        a.insert(5);
        a.insert(7);
        a.insert(9);
        System.out.println("printing first list");
        a.print();

        sort b = new sort();
        b.insert(2);
        b.insert(4);
        b.insert(5);
        b.insert(18);
        System.out.println("printing second list");
        b.print();

        System.out.println("printing merged list");
        a.head = a.listMerge(a.head,b.head);
        a.print();
    }
}
