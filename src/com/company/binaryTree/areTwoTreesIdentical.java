package com.company.binaryTree;

class qwe{
    int data;
    qwe left;
    qwe right;
    qwe(int x){
        data = x;
        left = right = null;
    }

    static qwe createTree(int[] arr, int[]index){
        int data = arr[index[0]];
        index[0]++;
        if (data==-1){
            return null;
        }

        qwe newNode = new qwe(data);
        newNode.left = createTree(arr,index);
        newNode.right = createTree(arr,index);
        return newNode;
    }


}
public class areTwoTreesIdentical {

    static boolean mirror(qwe root1,qwe root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.data != root2.data){
            return false;
        }

        boolean option1 = mirror(root1.left,root2.right);
        boolean option2 = mirror(root1.right,root2.left);

        return option1&&option2;
    }
    static boolean identical(qwe root1, qwe root2){

        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.data != root2.data){
            return false;
        }

        boolean option1 = identical(root1.left,root2.left);
        boolean option2 = identical(root1.right,root2.right);
        return option1&&option2;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,-1,-1,3,-1,-1};
        int index[] = {0};
        qwe tree1 = qwe.createTree(arr,index);

        int arr2[] = {1,2,-1,-1,3,-1,-1};
        int index2[] = {0};
        qwe tree2 = qwe.createTree(arr2,index2);

        boolean ans = identical(tree1,tree2);

        System.out.println("Identical : " + ans);
        int arr3[] = {1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};
        int index3[] = {0};
        qwe tree3 = qwe.createTree(arr3,index3);
        ans = mirror(tree3.left,tree3.right);
        System.out.println("Mirror : " + ans);
    }
}
