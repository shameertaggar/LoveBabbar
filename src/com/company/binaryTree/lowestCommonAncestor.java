package com.company.binaryTree;

import java.util.Scanner;

class trii{
    int data;
    trii left;
    trii right;

    trii(int x){
        data = x;
        left = null;
        right = null;
    }

    static trii createTrii(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1){
            return null;
        }
            trii t = new trii(data);

            t.left = createTrii();

            t.right = createTrii();

            return t;
    }

}
public class lowestCommonAncestor {
    public static void main(String[] args) {
        trii t = trii.createTrii();

        // done on leetCde
        //must revise it on notebook

    }
}
