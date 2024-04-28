package com.company.bst;


class bst{
    int data;
    bst left;
    bst right;
    bst(Integer x){
        data = x;
        left = right = null;
    }

    static bst insertIntoBst(bst root, int data) {
        if (root == null) {
            return new bst(data);
        }
        if (data > root.data) {
            root.right = insertIntoBst(root.right, data);
        } else if (data < root.data) {
            root.left = insertIntoBst(root.left, data);
        }

        return root;
    }

    static bst createTree(int arr[], int index) {
        if (index == arr.length || arr[index] == -1) {
            // If the index is out of bounds or the data is -1, return null
            return null;
        }

        bst root = new bst(arr[index++]);
        while (index < arr.length && arr[index] != -1) {
            root = insertIntoBst(root, arr[index++]);
        }

        return root;
    }
}
public class convertBSTtoDoublyLinkedList {
    static bst convert(bst root, bst head[]) {
        if (root == null) {
            return head[0];
        }

        // Recursively convert the right subtree
        head[0] = convert(root.right, head);

        // Update the pointers for doubly linked list
        root.right = head[0];

        if (head[0] != null) {
            head[0].left = root;
        }

        // Update head to the current node
        head[0] = root;

        // Recursively convert the left subtree
        head[0] = convert(root.left, head);

        return head[0];
    }

    static void printLinkList(bst root, bst head[]){
        bst curr = head[0];
        while(curr.right != null){
            System.out.print(curr.data+" -> ");
            curr = curr.right;
        }
    }
    public static void main(String[] args) {
        int[] arr = { 4, 2, 6, 1, 3, 5, 7, -1 };
        int index = 0;

        bst root = bst.createTree(arr, index);

        bst head[] = {null};
        convert(root,head);

        printLinkList(root,head);



    }
}
