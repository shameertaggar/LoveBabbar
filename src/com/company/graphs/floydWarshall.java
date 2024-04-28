package com.company.graphs;



import java.util.ArrayList;
import java.util.Arrays;
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
    int numVertices;
    ArrayList<Edge> edges;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int wt) {
        Edge edge = new Edge(u, v, wt);
        edges.add(edge);
    }

    public void print() {
        for (int i = 0; i < numVertices; i++) {
            for (Edge edge : edges) {
                if (edge.u == i) {
                    System.out.println(i + " -> ");
                    System.out.println(edge.v + " (" + edge.wt + ")");
                }
            }
        }
        System.out.println();
    }

    void floydWarshal(int n) {
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 1000000000);
            dist[i][i] = 0;
        }

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int wt = edge.wt;

            dist[u][v] = wt;

        }

        //helper logic
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // print distance array

        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j]+" ");
            }
        }

    }
}

public class floydWarshall {
    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0, 1, 3);
        g.addEdge(1, 0, 2);
        g.addEdge(0, 3, 5);
        g.addEdge(3, 2, 2);
        g.addEdge(2, 1, 1);
        g.addEdge(1, 3, 4);

        g.floydWarshal(4);
    }
}

