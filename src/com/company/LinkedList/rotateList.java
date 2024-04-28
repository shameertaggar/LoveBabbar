package com.company.LinkedList;

class rot{
    Node head;
    public int NodeNum() {
        int c = 0;

        Node curr = head;
        while(curr != null){
            curr = curr.next;
            c++;
        }
        return c;
    }

    public Node rotate(int c, int rotpara) {
        c = c-rotpara;
       Node curr = head;
       while(curr.next != null){
           curr = curr.next;
       }
       curr.next = head;
       int a = 0;
       Node cur = head;
       while (a<c-1){
           cur = cur.next;
           a++;
       }
       Node temp = cur.next;
       cur.next = null;
        System.out.println(temp.data);
       return temp;

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

    public Node reverse(Node head , int c ){
        Node curr = head;
        Node prev = null;
        int a = 0;
        while(curr != null && a<c){
            Node nNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nNext;
            a++;
        }

        return prev;
    }
}
public class rotateList {
    public static void main(String[] args) {
        rot a = new rot();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        a.insert(7);
        System.out.println("linked list");
        a.print();
        int c = a.NodeNum();
        int rotPara = 3;
        a.head = a.rotate(c,rotPara);
        a.print();





    }
}
