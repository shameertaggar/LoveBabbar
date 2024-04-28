package com.company.LinkedList;

class rev{
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
    public Node reverse(Node head, int k) {
        int a = k;
        Node prev = null;
        Node curr = head;

            int count = 0;
            while (curr != null && count < k) {
                Node nNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nNext;
                count++;
            }


            if (curr != null) {
                head.next = reverse(curr, a);
            }


            head = prev;


        return head;
    }

}

public class reverseKgroup {

    public static void main(String[] args) {
        rev a = new rev();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        a.insert(7);
        a.insert(8);
        a.insert(9);
        a.print();

        System.out.println("reversing ");
        a.reverse(a.head,2);
        a.print();

    }
}
