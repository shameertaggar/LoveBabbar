package com.company.practice.primsAlgo;

import java.util.*;

class Edge {
    int u;
    int v;
    int wt;

    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

class Graph {
    HashMap<Integer, List<Edge>> edges;

    public Graph() {
        edges = new HashMap<>();
    }

    void addEdge(int u, int v, int wt) {
        Edge e1 = new Edge(u, v, wt);
        Edge e2 = new Edge(v, u, wt);
        if (!edges.containsKey(u)) {
            edges.put(u, new ArrayList<>());
        }
        if (!edges.containsKey(v)) {
            edges.put(v, new ArrayList<>());
        }
        edges.get(u).add(e1);
        edges.get(v).add(e2);
    }

    void print() {
        for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
            List<Edge> nbr = entry.getValue();
            if (nbr != null) {
                for (Edge e : nbr) {
                    System.out.println(e.u + " connected with " + e.v + " (" + e.wt + ")");
                }
            }
        }
    }

    void primsAlgo(int src, int n) {
        int key[] = new int[n];
        boolean mst[] = new boolean[n];
        int parent[] = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        Arrays.fill(parent, -1);
        key[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minNode = getMnNode(key, mst);
            mst[minNode] = true;
            List<Edge> nbr = edges.get(minNode);
            if (nbr != null) {
                for (Edge e : nbr) {
                    int v = e.v;
                    int wt = e.wt;
                    if (!mst[v] && wt < key[v]) {
                        key[v] = wt;
                        parent[v] = minNode;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (parent[i] != -1) {
                List<Edge> e = edges.get(i);
                for (Edge edge : e) {
                    if (edge.v == parent[i]) {
                        sum += edge.wt;
                        break;
                    }
                }
            }
        }
        System.out.println("Weight sum is " + sum);
    }

    int getMnNode(int key[], boolean mst[]) {
        int temp = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < key.length; i++) {
            if (key[i] < temp && !mst[i]) {
                temp = key[i];
                ind = i;
            }
        }
        return ind;
    }
}

public class prim {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.print();
        g.primsAlgo(0, 5);
    }
}
