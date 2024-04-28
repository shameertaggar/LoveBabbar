package com.company.LinkedList;


import java.sql.SQLOutput;

class Num{
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

    public void add(Node head1, Node head2){
        System.out.println("entered in add");
        Num ad = new Num();
        int carry = 0;
        while(head1 != null || head2 !=null){
            int x = (head1 != null) ? head1.data : 0;
            int y = (head2 != null) ? head2.data : 0;
            int sum = x + y + carry;
            carry = sum/10;

            ad.insert(sum%10);

            if (head1 != null){
                head1 = head1.next;
            }
            if (head2 != null){
                head2 = head2.next;
            }
        }
        if (carry > 0)
            ad.insert(carry);

        ad.reverse();
        ad.print();

    }
}
public class addTwoNumbersRepresentedByLL {
    public static void main(String[] args) {
        Num a = new Num();
        a.insert(9);
        a.insert(9);
        a.insert(9);
        System.out.println("printing node one \n");
        a.print();
        Num b = new Num();
        b.insert(9);
        b.insert(9);
        b.insert(9);
        b.insert(3);
        System.out.println("Printing Node two \n");
        b.print();

        System.out.println("reversing both nodes ");
        a.reverse();
        b.reverse();

        // Call the add method on list1 and pass list2 as an argument
        System.out.println("Adding both lists:");
        a.add(a.head, b.head);







    }
}
