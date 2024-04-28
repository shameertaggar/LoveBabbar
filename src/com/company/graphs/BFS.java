package com.company.graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import java.util.*;

class grap {
    HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();

    void addEdge(int u, int v, boolean direction) {
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
        for (Map.Entry<Integer, ArrayList<Integer>> entry : list.entrySet()) {
            System.out.print(entry.getKey() + " : {");
            ArrayList<Integer> node = entry.getValue();

            for (int i = 0; i < node.size(); i++) {
                System.out.print(node.get(i) + "->");
            }
            System.out.print("}\n");
        }
    }

    void bfsTraverse(int src,HashMap<Integer, Boolean> visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.remove();
            System.out.print(frontNode + " ");


            if (list.containsKey(frontNode)){
                System.out.println();
                for (Integer nbr : list.get(frontNode)) {
                    if (!visited.containsKey(nbr) ) {
                        q.add(nbr);
                        visited.put(nbr, true);
                    }
                }

            }
        }
    }
}

public class BFS {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> visited = new HashMap<>();


        grap g = new grap();
        g.addEdge(0, 4, true);
        g.addEdge(0, 5, true);
        g.addEdge(0, 6, true);
        g.addEdge(4, 1, true);
        g.addEdge(4, 2, true);
        g.addEdge(5, 3, true);
        g.addEdge(6, 7, true);
//        g.addEdge(3, 6, false);
//        g.addEdge(6, 7, false);
//        g.addEdge(4, 10, true);
//        g.addEdge(5, 11, true);
//        g.addEdge(5, 12, true);



        g.print();
       // g.bfsTraverse(0,visited);

        // Initialize visited map with all vertices set to false
        for (int i = 0; i <= 8; i++) {
            visited.put(i, false);
        }

        for (int i = 0; i <=8; i++){
            if (!visited.get(i)){
                g.bfsTraverse(i,visited);
            }
        }
    }
}

