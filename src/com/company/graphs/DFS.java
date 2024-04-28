package com.company.graphs;

import java.util.ArrayList;
import java.util.HashMap;

class graphh {
    HashMap<Character, ArrayList<Character>> list = new HashMap<>();

    void addEdge(char u, char v, boolean direction) {
        if (direction) {
            if (!list.containsKey(u)) {
                list.put(u, new ArrayList<>());
            }
            list.get(u).add(v);
        } else {
            if (!list.containsKey(u)) {
                list.put(u, new ArrayList<>());
            }
            list.get(u).add(v);
            if (!list.containsKey(v)) {
                list.put(v, new ArrayList<>());
            }
            list.get(v).add(u);
        }
    }

    void print() {
        for (HashMap.Entry<Character, ArrayList<Character>> entry : list.entrySet()) {
            System.out.print(entry.getKey() + " : {");
            ArrayList<Character> nbr = entry.getValue();
            for (int i = 0; i < nbr.size(); i++) {
                System.out.print(nbr.get(i) + ",");
            }
            System.out.print("}");
            System.out.println();
        }
    }

    void dfsTraverse(char src, HashMap<Character, Boolean> visited) {
        visited.put(src, true);
        System.out.print(src + " ");

        if (list.containsKey(src)){
            for (Character nbr : list.get(src)) {
                if (!visited.containsKey(nbr) || !visited.get(nbr)) {
                    dfsTraverse(nbr, visited);
                }
            }
        }

    }
}

public class DFS {
    public static void main(String[] args) {
        HashMap<Character, Boolean> visited = new HashMap<>();
        for (char i = 'a'; i <= 'g'; i++) {
            visited.put(i, false);
        }
        graphh g = new graphh();
        g.addEdge('a', 'b', true);
        g.addEdge('a', 'c', true);
        g.addEdge('b', 'd', true);
        g.addEdge('b', 'e', true);
        g.addEdge('c', 'f', true);
        g.addEdge('c', 'g', true);
        g.print();

        g.dfsTraverse('a', visited);
    }
}
