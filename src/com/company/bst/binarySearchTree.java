package com.company.bst;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }

    static Node insertIntoBst(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data > root.data) {
            root.right = insertIntoBst(root.right, data);
        }
        if (data < root.data) {
            root.left = insertIntoBst(root.left, data);
        }

        return root;
    }

    static void createTree(int arr[], int index[], Node root[]) {
        if (index[0] == arr.length || arr[index[0]] == -1) {
            // If the index is out of bounds or the data is -1, return null
            return;
        }

        int data = arr[index[0]++];
        while (data != -1) {
            root[0] = insertIntoBst(root[0], data);
            data = arr[index[0]++];
        }
    }

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(null);
        q.add(root);

        while (q.size() > 1) {
            Node front = q.peek();
            q.remove();
            if (front == null) {
                System.out.println();
                q.add(null);
            } else {
                System.out.print(front.data + " ");
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }
    }

    static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }

    static void postOrder(Node root){
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
}

public class binarySearchTree {
    public static void main(String[] args) {
        int arr[] = {50, 30, 40, 20, 60, 55, 70, 80, 25, -1};
        int index[] = {0};

        Node[] n = new Node[1];
        Node.createTree(arr, index, n);

        if (n[0] != null && n[0].right != null) {
            System.out.println("Right child of root: " + n[0].right.data);
        }

        Node.levelOrder(n[0]);
        System.out.println("\n\nprinting preOrder traversal");
        Node.preOrder(n[0]);
        System.out.println("\n\nprinting inOrder traversal");
        Node.inOrder(n[0]);
        System.out.println("\n\nprinting postOrder traversal");
        Node.postOrder(n[0]);
    }
}
