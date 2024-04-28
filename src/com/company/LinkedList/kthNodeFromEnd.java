package com.company.LinkedList;

class MutableInt {
    int value;

    MutableInt(int value) {
        this.value = value;
    }
}
class kth{
    Node head;


    public void FromEnd(Node head, MutableInt pos, MutableInt ans) {

        if (head == null){
            System.out.println("returning");
            return;
        }else{
            System.out.println(head.data);
        }

        FromEnd(head.next,pos,ans);

        if (pos.value == 0){
            ans.value = head.data;
        }
       // System.out.println("position : "+ pos.value);
        pos.value--;
    }

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
}
public class kthNodeFromEnd {
    public static void main(String[] args) {
        kth a = new kth();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(6);
        a.insert(7);
        a.insert(8);
        MutableInt pos = new MutableInt(2);
        MutableInt ans = new MutableInt(-1);
        a.FromEnd(a.head,pos,ans);
        System.out.println(ans.value);

    }
}
