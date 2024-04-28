package com.company.LinkedList;


// 7 5 8 3

class RevList{
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
         if (head == null){
             head = newNode;
         }else{
             Node curr = head;
             while (curr.next!=null){
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
public class reverseLinkedList {
    public static void main(String[] args) {

        RevList r = new RevList();
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.insert(4);
        r.insert(5);
        r.insert(6);
        System.out.println("printing the list");
        r.print();
        System.out.println("reversing the list");
        r.reverse();
        r.print();


    }
}
