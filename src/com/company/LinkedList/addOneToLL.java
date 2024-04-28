package com.company.LinkedList;


class addOne{
    Node head;

    public void addition(Node head) {

            Node curr = head;
            while( curr != null ){
                if (curr.data < 9){
                    curr.data = curr.data +1;
                    return;
                } else{
                    curr.data = 0;
                    if (curr.next == null){
                        Node a = new Node(1);
                        curr.next = a;
                        return;
                    }
                }

                curr = curr.next;
            }

    }

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

    public void reverse(){
        Node prev = null;
        if (head==null){
            return;
        }else{
            Node curr = head;
            while (curr != null){
                Node nNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nNext;
            }
            head = prev;
        }
    }
}
public class addOneToLL {
    public static void main(String[] args) {

        addOne a = new addOne();
        a.insert(9);
        a.insert(9);
        a.insert(9);
        int carry;

        System.out.println("printing linked list");
        a.print();
        System.out.println("reversing ");
        a.reverse();
        a.print();
        a.addition(a.head);

        a.print();
        a.reverse();
        a.print();

    }


}
