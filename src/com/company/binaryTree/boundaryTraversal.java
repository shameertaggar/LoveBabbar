package com.company.binaryTree;

import javax.swing.*;
import java.util.ArrayList;

// there will be three parts
// part A, part b, part c
// in part A, just print  above the leaf
class qaz{
    int data;
    qaz left;
    qaz right;
    qaz(int x){
        data = x;
        left = right = null;
    }


    static qaz createTree(int arr[] , int index[]){
        int data = arr[index[0]];
        index[0] ++;
        if (data ==-1){
            return null;
        }

        qaz newNode = new qaz(data);
        newNode.left = createTree(arr,index);
        newNode.right = createTree(arr,index);
        return newNode;

    }
}

public class boundaryTraversal {

    static void printLeftBoundary(qaz root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (root.left ==null && root.right == null){
            return;
        }

        System.out.print(root.data + " ");
        list.add(root.data);
        if (root.left != null){
            printLeftBoundary(root.left,list);
        }else{
            printLeftBoundary(root.right,list);
        }
    }

    static void leafNodeTraverse(qaz root,ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(root.data);
            System.out.print(root.data + " ");
        }
        leafNodeTraverse(root.left,list);
        leafNodeTraverse(root.right,list);
    }

    static void printRightBoundary(qaz root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (root.left ==null && root.right == null){
            return;
        }

        if (root.right != null){
            printRightBoundary(root.right,list);
        }else{
            printRightBoundary(root.left,list);
        }
        System.out.print(root.data + " ");
        list.add(root.data);
    }
    public static void main(String[] args) {
        int arr [] = {10,20,40,-1,-1,50,70,110,-1,-1,111,-1,-1,80,-1,-1,30,-1,60,-1,90,112,-1,-1,113,-1,-1};
        int[] index = {0};

        qaz n = qaz.createTree(arr,index);
        ArrayList<Integer> list = new ArrayList<>();
        boundaryTraverse(n,list);



    }

    private static void boundaryTraverse(qaz root, ArrayList<Integer> list) {
        if (root == null){
            return;
        }


        System.out.println("printLeftBoundary\n");
        printLeftBoundary(root,list);
        System.out.println();
        System.out.println("leafNodeTraverse\n");
        leafNodeTraverse(root,list);
        System.out.println();
        System.out.println("printRightBoundary\n");
        printRightBoundary(root.right,list);
    }
}
