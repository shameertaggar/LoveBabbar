package com.company.LinkedList;

class del{
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

    public void remove(int m,int n){

         int a = 0;
         int q = m;
         int w = n;
         m = m-1;
         if (head == null || head.next == null){
             return;
         }else{
             Node curr = head;
             while(curr.next != null){
                 System.out.println(++a + "  data  :" + curr.data + "  value of m  :" + m +"  value of n  :" + n);
                  if (m==0){
                         curr.next = curr.next.next;
                      n--;
                    if (n == 0){
                        m = q;
                        n = w;
                    }



                 }else{
                      curr = curr.next;
                      m--;
                  }
             }
         }
    }
}

public class deleteMNodeAfterNNodes {
    public static void main(String[] args) {

        del a = new del();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);



        System.out.println("printing the linked list");
        a.print();


        System.out.println("removing m nodes after k nodes");
        a.remove(4,3);
        a.print();
    }
}
