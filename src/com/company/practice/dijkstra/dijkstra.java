package com.company.practice.dijkstra;

import javafx.util.Pair;

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
        Edge e2 = new Edge(v, u, wt); // add the reverse edge for undirected graph
        if (!edges.containsKey(u)) {
            edges.put(u, new ArrayList<>());
        }
        edges.get(u).add(e1);
        if (!edges.containsKey(v)) {
            edges.put(v, new ArrayList<>());
        }
        edges.get(v).add(e2);
    }

    void print() {
        for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
            int u = entry.getKey();
            List<Edge> nbr = entry.getValue();
            if (nbr != null) {
                for (Edge e : nbr) {
                    System.out.println(e.u + " connected with " + e.v + " (" + e.wt + ")");
                }
            }
        }
    }

    void shortestPathDijkstra(int src) {
        TreeMap<Integer, Integer> set = new TreeMap<>();
        int dist[] = new int[edges.size() + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        set.put(0, src);

        while (!set.isEmpty()) {
            int currentDist = set.firstKey();
            int node = set.remove(currentDist);
            List<Edge> nbr = edges.get(node);
            if (nbr != null) {
                for (Edge e : nbr) {
                    int nbrNode = e.v;
                    int edgeWeight = e.wt;
                    int newDist = currentDist + edgeWeight;
                    if (newDist < dist[nbrNode]) {
                        dist[nbrNode] = newDist;
                        set.put(newDist, nbrNode);
                    }
                }
            }
        }

        System.out.println("Printing distance array:");
        System.out.println("Vertex     Distance");
        for (int i = 1; i < dist.length; i++) {
            System.out.println(i + "            " + dist[i]);
        }
    }
}

public class dijkstra {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 3, 9);
        g.addEdge(1, 6, 14);
        g.addEdge(1, 2, 7);
        g.addEdge(3, 6, 2);
        g.addEdge(3, 2, 10);
        g.addEdge(3, 4, 11);
        g.addEdge(2, 4, 15);
        g.addEdge(4, 5, 6);
        g.addEdge(5, 6, 9);

        g.print();
        g.shortestPathDijkstra(6);
    }
}
