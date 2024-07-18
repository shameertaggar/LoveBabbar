package com.company.practice.stronglyConnectedComponent;

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
        Edge e = new Edge(u, v, wt);
        if (!edges.containsKey(u)) {
            edges.put(u, new ArrayList<>());
        }
        edges.get(u).add(e);
        // Ensure all vertices are in the edges map
        if (!edges.containsKey(v)) {
            edges.put(v, new ArrayList<>());
        }
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

    void topSortOrder(Stack<Integer> st) {
        Set<Integer> vertices = getVertices();

        boolean[] vis = new boolean[Collections.max(vertices) + 1];
        Arrays.fill(vis, false);

        for (int v : vertices) {
            if (!vis[v]) {
                dfs(v, vis, st);
            }
        }
    }

    private void dfs(int i, boolean[] vis, Stack<Integer> st) {
        vis[i] = true;

        List<Edge> nbr = edges.get(i);
        if (nbr != null) {
            for (Edge e : nbr) {
                if (!vis[e.v]) {
                    dfs(e.v, vis, st);
                }
            }
        }
        st.add(i);
    }

    void reverseEdges() {
        HashMap<Integer, List<Edge>> reversedEdges = new HashMap<>();

        for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
            List<Edge> nbr = entry.getValue();
            if (nbr != null) {
                for (Edge e : nbr) {
                    Edge reversedEdge = new Edge(e.v, e.u, e.wt);
                    if (!reversedEdges.containsKey(reversedEdge.u)) {
                        reversedEdges.put(reversedEdge.u, new ArrayList<>());
                    }
                    reversedEdges.get(reversedEdge.u).add(reversedEdge);
                }
            }
        }
        edges = reversedEdges;
    }

    void topScc(int[] ans, Stack<Integer> order) {
        Set<Integer> vertices = getVertices();

        boolean[] vis = new boolean[Collections.max(vertices) + 1];
        Arrays.fill(vis, false);

        while (!order.isEmpty()) {
            int v = order.pop();
            if (!vis[v]) {
                dfsScc(v, vis);
                ans[0]++;
            }
        }
    }

    private void dfsScc(int i, boolean[] vis) {
        vis[i] = true;

        List<Edge> nbr = edges.get(i);
        if (nbr != null) {
            for (Edge e : nbr) {
                if (!vis[e.v]) {
                    dfsScc(e.v, vis);
                }
            }
        }
    }

    private Set<Integer> getVertices() {
        Set<Integer> vertices = new HashSet<>(edges.keySet());
        for (List<Edge> edgesList : edges.values()) {
            for (Edge e : edgesList) {
                vertices.add(e.v);
            }
        }
        return vertices;
    }
}

public class stronglyCc {

    public static void main(String[] args) {

        Graph g = new Graph();
        g.addEdge(0, 1, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(3,0,0);
        g.addEdge(2, 4, 0);
        g.addEdge(4, 5, 0);
        g.addEdge(5, 6, 0);
        g.addEdge(6, 4, 0);
        g.addEdge(6, 7, 0);

        Stack<Integer> st = new Stack<>();
        g.topSortOrder(st);

        g.reverseEdges();

        int[] ans = {0};
        g.topScc(ans, st);
        System.out.println("\n\n Strongly connected components are : " + ans[0]);
    }
}
