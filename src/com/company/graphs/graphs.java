package com.company.graphs;


import java.util.ArrayList;
import java.util.HashMap;

class graph{
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    void addEdge(int u, int v, boolean direction){
        // direction -> 0 -> undirected
        // direction -> 1 -> directed
        if (direction){
            if (!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            adjList.get(u).add(v);
        }else{
            if (!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            adjList.get(u).add(v);
            if (!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            adjList.get(v).add(u);

        }
        printAdjList();

    }

    void printAdjList() {
        System.out.println("printing graph ");
        for (HashMap.Entry<Integer, ArrayList<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            ArrayList<Integer> neighbors = entry.getValue();
            for (int i = 0; i < neighbors.size(); i++) {
                System.out.print(neighbors.get(i));
                if (i < neighbors.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }


    void print(){
        for (HashMap.Entry<Integer,ArrayList<Integer>> entry : adjList.entrySet()){
            System.out.println(entry.getKey()+" -> ");
            ArrayList<Integer> neigh = entry.getValue();
            for (int i = 0; i< neigh.size(); i++){
                System.out.println(neigh.get(i) + " -> ");

            }
        }
    }

}

class weightedGraphs {
    HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> wtList = new HashMap<>();

    void addEdge(int u, int v, boolean direction, int wt) {
        HashMap<Integer, Integer> pair = new HashMap<>();
        if (direction) {
            if (!wtList.containsKey(u)) {
                wtList.put(u, new ArrayList<>());
            }
            pair.put(v, wt);
            wtList.get(u).add(pair);
        } else {
            if (!wtList.containsKey(u)) {
                wtList.put(u, new ArrayList<>());
            }
            pair.put(v, wt);
            wtList.get(u).add(pair);

            if (!wtList.containsKey(v)) {
                wtList.put(v, new ArrayList<>());
            }
            // Corrected: use v instead of u
            pair = new HashMap<>();
            pair.put(u, wt);
            wtList.get(v).add(pair);
        }
    }

    void printWt() {
        System.out.println("printing graph");
        for (HashMap.Entry<Integer, ArrayList<HashMap<Integer, Integer>>> entry : wtList.entrySet()) {
            System.out.print(entry.getKey() + " : {");
            ArrayList<HashMap<Integer, Integer>> node = entry.getValue();
            for (int i = 0; i < node.size(); i++) {
                HashMap<Integer, Integer> pair = node.get(i);

                System.out.print(" {" + i + "," + pair.values() + "},");
            }
            System.out.println("}");
        }
    }
}
public class graphs {
    public static void main(String[] args) {
        graph g = new graph();
        g.addEdge(0,1,false);
        g.addEdge(1,2,false);
        g.addEdge(1,3,false);
        g.addEdge(2,3,false);
//        g.addEdge(1,2,true);
//        g.addEdge(1,2,true);

        System.out.println("\n\n Printing weighted graph");

        weightedGraphs wtG = new weightedGraphs();
        wtG.addEdge(0,1,false,5);
        wtG.addEdge(1,2,false,10);
        wtG.addEdge(1,3,false,20);
        wtG.addEdge(2,3,false,50);
        wtG.printWt();


    }
}
