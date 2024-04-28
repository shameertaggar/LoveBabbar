package com.company.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        data = d;
        this.left = null;
        this.right = null;
    }

    static Node createTree(int[] arr, int[] index){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value for node");
        int data = arr[index[0]];
        index[0]++;
        if (data == -1){
            return null;
        }
        // step1: Node has been create
        Node newNode = new Node(data);

        // step2: create first subtree
        System.out.println("enter the value for left node  of " + data);
        newNode.left  = createTree(arr,index);
        // step3: create left subtree
        System.out.println("enter the value for right node of " + data);
        newNode.right = createTree(arr,index);

        return newNode;
    }

    static void preOrderTraversal(Node root){

        //NLR
        if (root == null){
            return;
        }

        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    static void inOrderTraversal(Node root){
        //LNR
        if (root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){

        //LRN
        if (root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    static void kthAncestor(Node root, int ans, int k, int data, Stack<Integer> s){
        if (root == null){
            return;
        }
        if (root.data == data){

            int e= k-1;
            for (int i = 0; i<e; i++){
                s.pop();
                k--;
            }
            System.out.println("Answer is : " + s.pop());
            return;
        }


        s.push(root.data);
        kthAncestor(root.left,ans,k,data,s);
        kthAncestor(root.right,ans,k,data,s);

        if (!s.isEmpty()) {
            s.pop();
        }
    }



    static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(null);
        q.add(root);
        while (q.size() > 1){
            Node front = q.peek();
            q.remove();
            if (front == null){
                System.out.println();
                System.out.println("Left view : " +q.peek().data);
                q.add(null);

            }else{
                System.out.print(front.data + " ");
                if (front.left != null){
                    q.add(front.left);
                }
                if (front.right != null){
                    q.add(front.right);
                }
            }
        }
        if (root == null){
            return;
        }
    }
}
public class createBinaryTree {
    public static void main(String[] args) {

        int arr [] = {10,15,25,-1,45,65,-1,-1,96,-1,-1,-1,11,16,-1,-1,-1};
        int[] index = {0};
        Node root = Node.createTree(arr,index);
        System.out.println(root.data);
        System.out.println("preORder traversal");
        Node.preOrderTraversal(root);
        System.out.println("InOrder Traversal");
        Node.inOrderTraversal(root);
        System.out.println("PostOrder Traversal");
        Node.postOrderTraversal(root);
        System.out.println("level order traversal");
        Node.levelOrderTraversal(root);

        Stack<Integer> s = new Stack<>();
        int ans = 0;
        int k = 2;
        int target = 6;
        System.out.println();
        System.out.println("finding kth ancestor");
         Node.kthAncestor(root,ans,k,target,s);
        System.out.println(ans);

       // 10 20 40-1 -1 -1 30 50 -1 -1 60 -1 -1
    }
}
