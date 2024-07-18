package com.company.practice;

import java.util.*;

class edgee {
    int u;
    int v;
    int wt;

    edgee(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

class grapphh {
    HashMap<Integer, List<edgee>> edges;
    int numVertices;

    public grapphh(int numVertices) {
        this.numVertices = numVertices;
        edges = new HashMap<>();
    }

    void addEdge(int u, int v, int wt) {
        edgee e = new edgee(u, v, wt);
        if (!edges.containsKey(u)) {
            edges.put(u, new ArrayList<>());
        }
        edges.get(u).add(e);
    }

    void print() {
        for (Map.Entry<Integer, List<edgee>> entry : edges.entrySet()) {
            int u = entry.getKey();
            List<edgee> nbr = entry.getValue();
            if (nbr != null) {
                for (edgee e : nbr) {
                    System.out.println(e.u + " connected with " + e.v + " (" + e.wt + ")");
                }
            }
        }
    }

    void dfs(Stack<Integer> st) {
        boolean vis[] = new boolean[numVertices];
        Arrays.fill(vis, false);

        for (int i = 0; i < numVertices; i++) {
            if (!vis[i]) {
                topSort(i, vis, st);
            }
        }
    }

    void topSort(int start, boolean vis[], Stack<Integer> st) {
        vis[start] = true;

        List<edgee> nbr = edges.get(start);
        if (nbr != null) {
            for (edgee e : nbr) {
                if (!vis[e.v]) {
                    topSort(e.v, vis, st);
                }
            }
        }
        st.add(start);
    }

    void shortestPathDfs(Stack<Integer> st,int dist[]){
        int src = st.pop();
        dist[src] = 0;
        // update neigbour distance for source node
        List<edgee> nbr = edges.get(src);
        for (edgee e : nbr){
            int nbrNode = e.v;
            int nbrNodeDist = e.wt;
            int totalDist = nbrNodeDist+dist[src];
            if (totalDist < dist[nbrNode]){
                dist[nbrNode] = totalDist;
            }
        }

        while (!st.isEmpty()){
            int source = st.pop();
            List<edgee> nbrr = edges.get(source);
            if (nbrr!=null){
                for (edgee e : nbrr) {
                    int nbrNode = e.v;
                    int nbrNodeDist = e.wt;
                    int totalDist = nbrNodeDist+dist[source];
                    if (totalDist < dist[nbrNode]){
                        dist[nbrNode] = totalDist;
                    }
                }
            }

        }
    }
}

public class shortPathDirected {
    public static void main(String[] args) {
        int numVertices = 5;
        grapphh g = new grapphh(numVertices);  // Update this with the total number of vertices
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 3, 5);
        g.addEdge(2, 4, 6);
        g.addEdge(4, 3, 1);

        g.print();

        Stack<Integer> st = new Stack<>();
        g.dfs(st);
        System.out.println(st);

        int dist[] = new int[numVertices];
        Arrays.fill(dist,Integer.MAX_VALUE);

        System.out.println("Printing the distance array");
        g.shortestPathDfs(st,dist);
        for (int i : dist){
            System.out.print(i + " ");
        }
    }
}
