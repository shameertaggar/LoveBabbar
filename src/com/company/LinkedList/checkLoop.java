package com.company.LinkedList;

class loop{
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

    public boolean check(){
        Node slow = head;
        Node fast = head;
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                System.out.println("fast : " + fast.data + " slow : " + slow.data);
                return true;
            }
        }

        return false;
    }

    public void removeLoop() {
        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Detect the loop
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // If no loop is detected
        if (slow != fast) {
            System.out.println("No loop detected");
            return;
        }

        // Move one of the pointers to the head of the list and advance both pointers at the same pace
        slow = head;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
            if (slow == fast){
                System.out.println("loop removed with" + slow.data + " fast " + fast.data);
            }
        }

        // Remove the loop by setting the next of the last node in the loop to null
        prev.next = null;

        System.out.println("Loop removed successfully");
    }

}


public class checkLoop {
    public static void main(String[] args) {
        loop a = new loop();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        a.insert(7);
        a.insert(8);
        a.insert(9);
//        a.insert(10);

        System.out.println("printing linked list ");
        a.print();

        // Create a loop by making the last node point to a node earlier in the list (e.g., node with data 3)
        loop.Node currentNode = a.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = a.head.next.next.next; // Point to the node with data 3



        // You can now use the check() method to detect the loop
        if (a.check()) {
            System.out.println("The linked list has a loop.");
        } else {
            System.out.println("The linked list does not have a loop.");
        }

        System.out.println();
        System.out.println("removing loop");
        a.removeLoop();
        a.print();

    }
}
