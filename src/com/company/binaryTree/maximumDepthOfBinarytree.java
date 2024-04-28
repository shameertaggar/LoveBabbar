package com.company.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Nodee{
    int data;
    Nodee left;
    Nodee right;

    Nodee(int x){
        data = x;
        this.left = null;
        this.right = null;
    }

    static Nodee createTree(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1){
            return null;
        }
        Nodee newNode = new Nodee(data);

        // step2: create first subtree
       // System.out.println("enter the value for left node  of " + data);
        newNode.left  = createTree();
        // step3: create left subtree
       // System.out.println("enter the value for right node of " + data);
        newNode.right = createTree();

        return newNode;

    }

    static int maxHeight(Nodee root){
        if (root == null)
            return 0 ;

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        int maxHyt = Math.max(leftHeight,rightHeight)+1;
        return maxHyt;
    }
}
public class maximumDepthOfBinarytree {
    public static void main(String[] args) {
        Nodee n = Nodee.createTree();
       int ans = Nodee.maxHeight(n);
        System.out.println("Depth is " + ans);
    }
}
