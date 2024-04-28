package com.company.tries;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.ArrayList;
import java.util.Vector;

class Node {
    char value;
    Node children[] = new Node[26];
    boolean isTerminal;

    Node(char val) {
        this.value = val;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        this.isTerminal = false;
    }

    void insertNode(Node root, String word) {

        //   System.out.println("received word : " + word +" for insertion ");
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        Node child;
        index = Math.max(0, Math.min(index, 25));

        if (root.children[index] != null) {
            // present
            child = root.children[index];
        } else {
            //absent
             child = new Node(ch);
            root.children[index] = child;
        }

        // recursion
        insertNode(child, word.substring(1));
    }

    boolean search(Node root, String word) {
        if (word.length() == 0) {
            return root.isTerminal;
        }
        char ch = word.charAt(0);
        int index = ch - 'a';
        index = Math.max(0, Math.min(index, 25));

        Node child;
        if (root.children[index] != null) {
            //present
            child = root.children[index];
        } else {
            //absent
            return false;
        }

        boolean recAns = search(child, word.substring(1));

        return recAns;

    }

    void delete(Node root, String word) {
        if (word.length() == 0) {
            root.isTerminal = false;
            return;
        }
        char ch = word.charAt(0);
        int index = ch - 'a';
        index = Math.max(0, Math.min(index, 25));

        Node child;
        if (root.children[index] != null) {
            //present
            child = root.children[index];
        } else {
            //absent
            return ;
        }

       delete(child, word.substring(1));

        return ;

    }

    void storeString(Node root,  ArrayList<String> suffix, String input,String prefix){

        if (root.isTerminal){
            suffix.add( prefix+input);
        }

        for (char ch = 'a'; ch <= 'z'; ch++){
            int index = ch-'a';
            Node next = root.children[index];
            if (next != null){
                 //chld exists
                input = input + ch;

                // baaki recursion
                storeString(next,suffix,input,prefix);
                //backtrack
                input = input.substring(0,input.length()-1);
            }
        }
    }

    void printAll(Node root, String input, ArrayList<String> list,String prefix){
        if (input.length()==0){
            Node lastChar = root;
            storeString(root,list,input,prefix);
            return;
        }
        char ch = input.charAt(0);

        int index = ch -'a';
        index = Math.max(0, Math.min(index, 25));
        Node child;

        if (root.children[index] != null){
            child = root.children[index];

        }else {
            return;
        }

        printAll(child,input.substring(1),list,prefix);

    }

    ArrayList<ArrayList<String>> getSuggestions(Node root,String input){

        ArrayList<ArrayList<String>> output = new ArrayList<>();
        Node prev = root;
        String inputHelper = "";
        for (int i = 0; i< input.length(); i++){
            char lastChar = input.charAt(i);
            int index = lastChar -'a';
            Node curr = prev.children[index];
            if (curr==null){
                break;
            }else{
                ArrayList<String> nicheKaAns = new ArrayList<>();
                inputHelper = inputHelper + lastChar;
                String dummy = "";
                storeString(curr,nicheKaAns,inputHelper,dummy);
                output.add(nicheKaAns);
                //important
                prev = curr;
            }


        }

        return output;
    }
}

public class createTrie {
    public static void main(String[] args) {
        Node root = new Node('-');
        root.insertNode(root,"cater");
        root.insertNode(root,"care");
        root.insertNode(root,"com");
        root.insertNode(root,"lover");
        root.insertNode(root,"loved");
        root.insertNode(root,"lov");
        root.insertNode(root,"bat");
        root.insertNode(root,"cat");
        root.insertNode(root,"car");
        root.insertNode(root,"load");
        root.insertNode(root,"long");
        root.insertNode(root,"lord");
        root.insertNode(root,"loarse");
        root.insertNode(root,"loki");
        root.insertNode(root,"londa");

        System.out.println("\n insertion completed");

        System.out.println("\n Finding element");
         boolean ans = root.search(root,"loved");
        System.out.println(ans);

        System.out.println("\n deleting element");
        System.out.println("\n Finding element");
        root.delete(root,"loved");
        ans = root.search(root,"loved");
        System.out.println(ans);

        System.out.println("\n\n");

        String input = "c";
        String prefix = input;

        ArrayList<String> ansList = new ArrayList<>();
        root.printAll(root,input,ansList,prefix);
        System.out.println("\n printing list of answers");
        System.out.println(ansList);


        System.out.println("\n");
        System.out.println("printing all answers");
        ArrayList<ArrayList<String>> output = root.getSuggestions(root,"lov");

        System.out.println(output);


    }
}
