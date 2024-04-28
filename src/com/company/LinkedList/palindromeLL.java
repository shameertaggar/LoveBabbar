package com.company.LinkedList;

// break into two halves
// reverse second half
//compare
class palindrome{
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

    public void print(Node head){
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

    public Node middle(){
        Node slow = head;
        Node fast = head;

        if (head == null){
            return null;
        }else{
            while(fast.next != null){
                fast = fast.next;
                if (fast.next!= null){
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return slow;
    }

    public Node reverse(Node head){
       Node prev = null;
        if (head==null){
            return null;
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
        return prev;
    }

    public boolean compare(Node head1, Node head2){
        while(head2 != null){
            System.out.println("head1 : " + head1.data + "  head2 : "+ head2.data);
            if (head1.data != head2.data){
                return false;
            }else{
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return true;
    }

}
public class palindromeLL {
    public static void main(String[] args) {
        palindrome a = new palindrome();
        a.insert(1);
        a.insert(2);
        a.insert(3);
      //  a.insert(4);
        a.insert(2);
        a.insert(1);
        System.out.println("printing the list");
        a.print(a.head);
       palindrome.Node q = a.middle();

        System.out.println("middle node is " + q.data);



        palindrome.Node head2 = q.next;
        q.next = null;
        head2 = a.reverse(head2);
        System.out.println("reversed Node");
        a.print(head2);


        System.out.println("\n //////////////////// ");
        System.out.println("comparing for plaindrome");

        boolean e = a.compare(a.head,head2);

        System.out.println(e);

    }
}
