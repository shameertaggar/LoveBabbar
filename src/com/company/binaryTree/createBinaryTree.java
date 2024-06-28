package com.company.binaryTree;

import javax.swing.event.MenuDragMouseListener;
import java.util.*;

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



    static List<List<Integer>> levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(null);
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node front = q.poll();

                if (front != null) {
                    levelNodes.add(front.data);
                    if (front.left != null) {
                        q.add(front.left);
                    }
                    if (front.right != null) {
                        q.add(front.right);
                    }
                }
            }

            if (!levelNodes.isEmpty()) {
                ans.add(levelNodes);
            }
        }
        if (root == null){
            return ans;
        }
        return ans;
    }
    static List<Integer> morris(Node root){
        List<Integer> ans = new ArrayList<>();
        Node curr = root;

        while(curr != null){
            //left node is null,then, visit it and go right
            if(curr.left == null){
                ans.add(curr.data);
                curr = curr.right;
            }else{
                //find inorder predecessor
                Node pred = curr.left;
                while(pred.right != curr && pred.right != null){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    // left is already visited
                    pred.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return ans;
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
        List<List<Integer>> anss = Node.levelOrderTraversal(root);
        for (int i = 0; i<anss.size(); i++){
            System.out.println(anss.get(i));
        }
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


