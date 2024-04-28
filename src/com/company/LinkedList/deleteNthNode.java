package com.company.LinkedList;

import javax.xml.soap.Node;

class LList{

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }

    }

    public void  insert(int d){

        Node newNode = new Node(d);
        if (head==null){
            head = newNode;
            return;
        }

        Node curr = head;

        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;

    }

    public void print(){
        if (head == null){
            return;
        }

            Node curr = head;

            while (curr != null){
                System.out.print(curr.data+" ");

                curr = curr.next;
            }
        System.out.println();

    }

    public void delete(int d){
        if (head.next == null || head == null){
            head = null;
            return;
        }else{
            Node curr = head;

            while(curr.next.data != d){
                curr = curr.next;
            }
            curr.next = curr.next.next;

        }
    }

    public void firstNodedelete(){
        if (head.next == null || head == null){
            head = null;
            return;
        }else{
            Node curr = head;


            head = curr.next;

        }
    }

    public void lastNodedelete(){
        if (head.next == null || head == null){
            head = null;
            return;
        }else{
            Node curr = head;
            while (curr.next.next != null){
                curr = curr.next;
            }
            curr.next = null;
        }
    }

    public void deleteAnyNode(int pos){
        if (head.next == null || head == null){
            head = null;
            return;
        }
        int c = 1;
        Node curr = head;
        while(c != pos-1){
            curr = curr.next;
            c++;
        }
        curr.next = curr.next.next;

    }


}

public class deleteNthNode {


    public static void main(String[] args) {
        LList a = new LList();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);

        a.print();
        System.out.println("after deletion");
        a.delete(3);
        a.print();

        System.out.println("after deleting first node");
        a.firstNodedelete();
        a.print();
        a.lastNodedelete();
        System.out.println("delete last node");
        a.print();

        System.out.println("after iserting more elements");
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.print();
        System.out.println("after deletig any node");
        a.deleteAnyNode(4);
        a.print();
    }
}
