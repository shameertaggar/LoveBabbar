package com.company.binaryTree;


import javafx.util.Pair;

import java.util.*;

class treee{
    int data;
    treee left;
    treee right;
     treee(int x){
          data = x;
         left = null;
         right = null;
     }

     static treee createTree(int[] arr, int[] index){
         int data = arr[index[0]];
         index[0]++;
         if (data == -1){
             return null;
         }
         treee t = new treee(data);

         System.out.println(data);
         t.left = createTree(arr, index);
         t.right = createTree(arr, index);

         return t;
     }

     static void left(treee t){
         Queue<treee> q = new LinkedList<>();
         q.add(null);
         q.add(t);


         while (q.size() > 1){
             treee front = q.peek();
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
         if (t == null){
             return;
         }
     }
}
public class leftRightBottomTop {

    static void leftVie(treee root, int[] level, ArrayList<Integer> list){

        if (root == null)
            return;

        if (level[0] == list.size()){
            System.out.println("level : " + level[0] +"  root  : " + root.data);
            list.add(root.data);
        }
        level[0] ++;
        leftVie(root.left,level,list);
        leftVie(root.right,level,list);
        level[0]--;
    }

    static void rightVie(treee root, int[] level, ArrayList<Integer> list){

        if (root == null)
            return;

        if (level[0] == list.size()){
            System.out.println("level : " + level[0] +"  root  : " + root.data);
            list.add(root.data);
        }
        level[0] ++;
        rightVie(root.right,level,list);
        rightVie(root.left,level,list);
         level[0]--;
    }

    static void topVie(treee root){
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair<treee, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
          while (!q.isEmpty()){
              Pair<treee, Integer> temp = q.remove();
              treee front = temp.getKey();
              int hd = temp.getValue();

              if (!map.containsKey(hd)){
                  map.put(hd,front.data);
              }

              if (front.left != null){
                  q.add(new Pair<>(front.left,hd-1));
              }
              if (front.right != null){
                  q.add(new Pair<>(front.right,hd+1));
              }
          }

          String r = map.toString();
        System.out.println(r);
    }


    static void bottomVie(treee root){
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair<treee, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while (!q.isEmpty()){
            Pair<treee, Integer> temp = q.remove();
            treee front = temp.getKey();
            int hd = temp.getValue();


                map.put(hd,front.data);


            if (front.left != null){
                q.add(new Pair<>(front.left,hd-1));
            }
            if (front.right != null){
                q.add(new Pair<>(front.right,hd+1));
            }
        }

        String r = map.toString();
        System.out.println(r);
    }
    public static void main(String[] args) {

        //{10,20,40,-1,-1,50,60,-1,-1,70,-1,-1,30,-1,-1};
        //
        int arr [] = {10,20,40,-1,-1,50,70,110,-1,-1,111,-1,-1,80,-1,-1,30,-1,60,-1,90,112,-1,-1,113,-1,-1};
        int[] index = {0};
        treee t = treee.createTree(arr,index);
        System.out.println("Printing leftVIew Of the Tree");
        t.left(t);
        ArrayList<Integer> list = new ArrayList<>();
        int[] level = {0};
        System.out.println("\n\n");
        System.out.println("printing leftview");

        leftVie(t,level,list);
        System.out.println(list);


        System.out.println("\n\n");
        System.out.println("printing right VIew");
        int[] levels = {0};
        ArrayList<Integer> list2 = new ArrayList<>();
        rightVie(t,levels,list2);
        System.out.println(list2);



        System.out.println("\n\n");
        System.out.println("printing top VIew");
        topVie(t);
       // System.out.println(list2);

        System.out.println("\n\n");
        System.out.println("printing bottom VIew");
        bottomVie(t);

    }
}
