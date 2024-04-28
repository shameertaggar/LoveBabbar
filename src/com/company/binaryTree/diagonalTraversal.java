package com.company.binaryTree;

import java.util.*;

class tri{
    int data;
    tri left;
    tri right;

    tri(int x){
        data = x;
        left = null;
        right = null;
    }

    static tri createTree(int arr[], int index[]){
        int data = arr[index[0]];
        index[0]++;

        if (data == -1){
            return null;
        }

        tri newNode = new tri(data);
        newNode.left = createTree(arr,index);
        newNode.right = createTree(arr,index);
        return newNode;
    }

    static void diaTraverse(tri root, HashMap<Integer, ArrayList<Integer>> map, int d){


        if (root==null){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (map.containsKey(d)){
            list = map.get(d);
            list.add(root.data);
            map.put(d,list);
        }else{
            list.add(root.data);
            map.put(d,list);
        }
            diaTraverse(root.left,map,++d);
            diaTraverse(root.right,map,--d);

    }


    static void diaTravers2(tri root, ArrayList<Integer> list){
        Queue<tri> q = new LinkedList<>();
        q.add(root);
        if (root == null){
            return;
        }


        while (q.size()>0){
            tri temp = q.remove();
            while (temp != null){
                list.add(temp.data);
                if (temp.left!= null){
                     q.add(temp.left);
                }
                temp = temp.right;
            }
        }

    }
}
public class diagonalTraversal {
    public static void main(String[] args) {
        int arr[] = {8,3,1,-1,-1,6,4,-1,-1,7,-1,-1,10,-1,14,13,-1,-1,-1};
        int index[] = {0};
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        tri root = tri.createTree(arr,index);
        int d = 0;
        tri.diaTraverse(root,map,d);

        System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("\n\nprinting diagonal with 2nd Method");
        tri.diaTravers2(root,list);
        System.out.println(list);

    }
}
