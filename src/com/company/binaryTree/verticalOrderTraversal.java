package com.company.binaryTree;

import java.util.*;

// learn tuple in java

class trri{
    int data;
    trri left;
    trri right;

    trri(int x){
        data = x;
        left = right = null;
    }

    static trri createTree(int arr[], int index[]){
        int data = arr[index[0]];
        index[0]++;
        if (data == -1){
            return null;
        }

        trri newNode = new trri(data);
        newNode.left = createTree(arr,index);
        newNode.right = createTree(arr,index);

        return newNode;
    }

    static void verticalTraverse(trri root, HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map){
        Queue<HashMap<trri, HashMap<Integer,Integer>>> q = new LinkedList<>();

        HashMap<Integer,Integer> rowCol = new HashMap<>();
        rowCol.put(0,0);

        HashMap<trri, HashMap<Integer, Integer>> pair = new HashMap<>();
        pair.put(root, rowCol);

        q.add(pair);

         while (!q.isEmpty()){
             HashMap<trri, HashMap<Integer, Integer>> front = q.remove();



             
         }
    }
}
public class verticalOrderTraversal {
    public static void main(String[] args) {
        HashMap<Integer,HashMap<Integer, ArrayList<Integer>>> map = new HashMap<>();
        int arr[] = {3,9,-1,-1,20};
        int index[] = {0};
        trri root = trri.createTree(arr,index);
        trri.verticalTraverse(root,map);

    }
}
