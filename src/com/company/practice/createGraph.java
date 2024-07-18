package com.company.practice;

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
    HashMap<Integer, List<Edge>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addEdge(int u, int v, int wt) {
        Edge e = new Edge(u, v, wt);
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(e);
    }

    public void print() {
        for (Map.Entry<Integer, List<Edge>> entry : graph.entrySet()) {
            int u = entry.getKey();
            List<Edge> edges = entry.getValue();
            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                System.out.println(e.u + " connected with " + e.v + " (" + e.wt + ")");
            }
        }
    }

    public void bfs() {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int vertex : graph.keySet()) {
            if (!vis.containsKey(vertex)) {
                bfsFromVertex(vertex, vis);
            }
        }
    }

    private void bfsFromVertex(int start, HashMap<Integer, Boolean> vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis.put(start, true);

        while (!q.isEmpty()) {
            int vertex = q.remove();
            System.out.print(vertex + " ");

            // Get the edges associated with the vertex
            List<Edge> edges = graph.get(vertex);
            if (edges != null) {
                for (Edge e : edges) {
                    if (!vis.containsKey(e.v)) {
                        q.add(e.v);
                        vis.put(e.v, true);
                    }
                }
            }
        }
        System.out.println();
    }

    public void topDfs(int start, boolean vis[], Stack<Integer> ans) {
        vis[start] = true;

        List<Edge> edges = graph.get(start);
        if (edges != null) {
            for (Edge edge : edges) {
                int v = edge.v;

                if (!vis[v]) {
                    topDfs(v, vis, ans);
                }
            }
        }

        ans.add(start);
    }


}

public class createGraph {
    public static void main(String[] args) {
        int n = 5;
        Graph g = new Graph();
        g.addEdge(0, 2, 3);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 3, 5);
        g.addEdge(2, 4, 6);
        g.addEdge(4, 3, 1);

        System.out.println("Graph Representation:");
        g.print();
        System.out.println("Printing BFS traversal:");
        g.bfs();

        Stack<Integer> top = new Stack<>();
        boolean vis[] = new boolean[n];
        Arrays.fill(vis, false);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                g.topDfs(i, vis, top);
            }
        }


    }
}
