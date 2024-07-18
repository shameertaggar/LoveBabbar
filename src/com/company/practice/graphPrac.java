package com.company.practice;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

class edges{
    int u;
    int v;
    int wt;
    edges(int u, int v, int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

class graphh{
    HashMap<Integer, List<edges>> graph ;
    void createGraph(){
        graph = new HashMap<>();
    }

    void addEdge(int u,int v,int wt){
        edges e = new edges(u,v,wt);
        if (!graph.containsKey(u)){
            graph.put(u,new ArrayList<>());
        }
        graph.get(u).add(e);
    }

    void print(){
        for (Map.Entry<Integer,List<edges>> entry : graph.entrySet()){
            List<edges> conn = entry.getValue();
            for (int i = 0; i < conn.size(); i++){
                System.out.println(conn.get(i).u + " is connected to " + conn.get(i).v + " with wt " + conn.get(i).wt);
            }
        }
    }

    public void bfs(int start){
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (Map.Entry<Integer,List<edges>> entry : graph.entrySet()){
            int vertex = entry.getKey();
            if(vis.containsKey(vertex)){
                continue;
            }
            bfsFromVertex(vertex,vis);
        }
    }

    public void dfs(int start){
        HashMap<Integer,Boolean> vis = new HashMap<>();

        for (Map.Entry<Integer,List<edges>> entry : graph.entrySet()){
            int vertex = entry.getKey();
            vis.put(vertex,false);
        }

        for (Map.Entry<Integer,List<edges>> entry : graph.entrySet()){
            int vertex = entry.getKey();
            if (vis.containsKey(vertex)){
                continue;
            }
            dfsFromVertex(start,vis);
        }
    }

    public void dfsFromVertex(int start, HashMap<Integer,Boolean> vis){
        vis.put(start,true);
        System.out.println(start);

        if (graph.containsKey(start)){
            for (edges e : graph.get(start)){
                if (!vis.containsKey(e.v) || !vis.get(e.v)){
                    dfsFromVertex(e.v,vis);
                }
            }
        }
    }
    public void bfsFromVertex(int start, HashMap<Integer, Boolean> vis ){

        vis.put(start,true);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()){
          //  System.out.println("entery");
            int vertex = q.remove();
            System.out.print(vertex + " ");

            List<edges> conn = graph.get(vertex);
            if (conn!=null){
                for (edges e : conn){
                    if (!vis.containsKey(e.v) ){
                        q.add(e.v);
                        vis.put(e.v,true);
                    }


                }
            }
            System.out.println();
        }
    }


}
public class graphPrac {
    public static void main(String[] args) {
        graphh g = new graphh();
        g.createGraph();
        g.addEdge(0, 1, 5);
        g.addEdge(3, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 0, 2);
        g.print();
        g.bfs(0);
        g.dfs(0);

    }
}
