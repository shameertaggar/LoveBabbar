package com.company.graphs;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Edge1 {
    int u, v, wt;
    Edge1(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

class graph1 {
    ArrayList<Edge1> Edges1;
    int numVertices;

    graph1(int numVertices) {
        this.numVertices = numVertices;
        Edges1 = new ArrayList<>(numVertices);
    }

    void addEdge(int u, int v, int wt) {
        Edge1 edge = new Edge1(u, v, wt);
        Edges1.add(edge);
    }

    void print() {
        for (Edge1 edge : Edges1) {
            System.out.println("Vertex " + edge.u + " is connected to vertex " + edge.v + " with weight " + edge.wt);
        }
    }

    void dfs(int i, Stack<Integer> order, HashMap<Integer, Boolean> visited) {
        visited.put(i, true);
        for (Edge1 nbr : Edges1) {
            if (nbr.u == i && !visited.getOrDefault(nbr.v, false)) { // Ensure to check if nbr.v is visited
                dfs(nbr.v, order, visited);
            }
        }
        order.push(i);
    }

    void dfsOnReversedGraph(int i, ArrayList<Edge1>[] reversedEdges, HashMap<Integer, Boolean> visited, ArrayList<Integer> component) {
        visited.put(i, true);
        component.add(i);
        for (Edge1 edge : reversedEdges[i]) {
            if (!visited.getOrDefault(edge.v,false)) {
                dfsOnReversedGraph(edge.v, reversedEdges, visited, component);
            }
        }
    }

    int getStronglyConnected() {
        Stack<Integer> order = new Stack<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        // Step 1: Perform DFS to get the ordering
        for (int i = 0; i < numVertices; i++) {
            if (!visited.getOrDefault(i, false)) {
                dfs(i, order, visited);
            }
        }

        // Step 2: Reverse the graph
        ArrayList<Edge1>[] reversedEdges = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            reversedEdges[i] = new ArrayList<>();
        }
        for (Edge1 edge : Edges1) {
            reversedEdges[edge.v].add(new Edge1(edge.v, edge.u, edge.wt));
        }

        // Step 3: Perform DFS on the reversed graph using the order obtained from Step 1
        visited.clear();
        ArrayList<ArrayList<Integer>> stronglyConnectedComponents = new ArrayList<>();
        while (!order.isEmpty()) {
            int vertex = order.pop();
            if (!visited.getOrDefault(vertex, false)) {
                ArrayList<Integer> component = new ArrayList<>();
                dfsOnReversedGraph(vertex, reversedEdges, visited, component);
                stronglyConnectedComponents.add(component);
            }
        }

        // Step 4: Return the number of strongly connected components
        return stronglyConnectedComponents.size();
    }
}

public class stronglyConnectedComponents {
    public static void main(String[] args) {
        graph1 g = new graph1(8);
        g.addEdge(0, 1, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 0, 2);
        g.addEdge(2, 4, 1);
        g.addEdge(4, 5, 4);
        g.addEdge(5, 6, 4);
        g.addEdge(6, 4, 4);
        g.addEdge(6, 7, 4);
        g.print();

        int ans = g.getStronglyConnected();
        System.out.println("Number of strongly connected components: " + ans);
    }
}

