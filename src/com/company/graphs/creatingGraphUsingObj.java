package com.company.graphs;

import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edgee{
    int u;
    int v;
    int wt;

     Edgee(int u , int v, int wt){
       this.u = u;
       this.v = v;
       this.wt = wt;
    }

}

class graphhh{
    ArrayList<Edgee> edges ;
    int numVertices;
    public graphhh(int numVertices){
        this.numVertices = numVertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int wt){
        Edgee edge = new Edgee(u,v,wt);
        edges.add(edge);
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {

            for (Edgee edge : edges) {
                if (edge.u == i) {
                    System.out.print("Vertex " + i + " is connected to: ");
                    System.out.print(edge.v + "(" + edge.wt + ") ");
                }
            }
            System.out.println();
        }
    }
}


public class creatingGraphUsingObj {
    public static void main(String[] args) {
        int numVertices = 5;
        graphhh graph = new graphhh(numVertices);

        // Adding directed edges to the graph
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 0, 2);
        graph.addEdge(3, 4, 1);

        // Print the graph
        System.out.println("Graph Representation:");
        graph.printGraph();

    }
}
