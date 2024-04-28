package com.company.binaryTree;


import java.util.Scanner;

class dia{
    int data;
    dia left;
    dia right;

    dia(int x){
        data = x;
        this.left = null;
        this.right = null;
    }

    static dia create(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1){
            return null;
        }
        dia newNode = new dia(data);

        // step2: create first subtree
        // System.out.println("enter the value for left node  of " + data);
        newNode.left = create();
        // step3: create left subtree
        // System.out.println("enter the value for right node of " + data);
        newNode.right = create();

        return newNode;
    }

    static int diameter(Node root){
        int diam = 0;
        if (root==null){
            return 0;
        }

        int option1 = diameter(root.left);
        int option2 = diameter(root.right);
        int option3 = height(root.left) + height(root.right)  + 1;

        return Math.max(option1,Math.max(option2,option3));
    }

    private static int height(Node root) {
        if (root == null)
            return 0 ;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int maxHyt = Math.max(leftHeight,rightHeight);
        return maxHyt;
    }
}
public class diameterOfBinaryTree {
    public static void main(String[] args) {
        dia d =dia.create();


    }
}
