package com.company.LinkedList;

class inter{
    Node head;

    public void checkIntersection(Node head, Node head1) {
        Node curr = head;
        Node curr1 = head1;

        while(curr != null && curr1 !=null){
            curr = curr.next;
            curr1 = curr1.next;
        }
        int cCurr = 0 ;
        int cCurr1 = 0;
        while (curr != null){
            curr = curr.next;
            cCurr++;
        }
        while (curr1 != null){
            curr1 = curr1.next;
            cCurr1++;
        }

        System.out.println("cCurr :" + cCurr +"  cCurr1 :"+ cCurr1);

        if (cCurr != 0){
            curr = head;
            while(cCurr > 0){
                curr = curr.next;
                cCurr--;
            }
            curr1 = head1;
            while (curr != null && curr1 != null){
                System.out.println("curr data :" + curr.data + "  curr1 Data :" + curr1.data);
                curr = curr.next;
                curr1 = curr1.next;
                if (curr == curr1){
                    System.out.println("Intersection is at Node with data :" + curr.data);
                    return;
                }
            }

        }else{
            curr1 = head1;
            while (cCurr1 >0){
                curr1 = curr1.next;
                cCurr1--;
            }
            curr = head;
            while (curr != null && curr1 != null){
                System.out.println("curr data :" + curr.data + "  curr1 Data :" + curr1.data);
                curr = curr.next;
                curr1 = curr1.next;
                if (curr == curr1){
                    System.out.println("Intersection is at Node with data :" + curr.data);
                    return;
                }
            }
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

    public void print(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data +"->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void insert(int d){
        Node newNode = new Node(d);


        if (head == null){
            head  = newNode;
        }else{
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }

    }
}
public class intersectionOfTwoLinkedList {
    public static void main(String[] args) {
        inter a = new inter();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        a.insert(7);
        a.insert(8);
        a.insert(9);

        inter b = new inter();
        b.insert(1);
        b.insert(2);
        b.insert(3);
        b.head.next.next.next = a.head.next.next.next.next.next;

        System.out.println("printing a");
        a.print();
        System.out.println("printing b");
        b.print();

        System.out.println("checking intersection point");
        a.checkIntersection(a.head,b.head);
    }
}
