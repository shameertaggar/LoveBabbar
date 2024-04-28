package com.company.graphs;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

class gph{
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    void addEdge(int u, int v, boolean direction){
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
    }

    void print(){
        for (HashMap.Entry<Integer,ArrayList<Integer>> entry : adjList.entrySet()){
            System.out.print(entry.getKey()+" -> ");
            ArrayList<Integer> nbr = entry.getValue();
            for (int i = 0; i < nbr.size(); i++){
                System.out.print(nbr.get(i)+" ");
            }
            System.out.println();
        }
    }

    void bfsTopSort(int n){
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,Integer> indegree = new HashMap<>();

        // calculate indegree
        for (ArrayList<Integer> nbrs: adjList.values()){
            for (int nbr: nbrs){
                indegree.put(nbr,indegree.getOrDefault(nbr,0)+1);
            }
        }

        //push indegrr 0 node into queue

        for (int node = 0; node < n; node++){
            if (indegree.getOrDefault(node,0)==0){
                q.add(node);
            }
        }

        // q empty

        while (!q.isEmpty()){
            int frontNode = q.remove();
            System.out.println(frontNode+ " , ");
            if (adjList.containsKey(frontNode)){
                for (Integer i : adjList.get(frontNode)){
                    indegree.put(i,indegree.get(i)-1);

                    if (indegree.get(i) == 0){
                        q.add(i);
                    }
                }
            }
        }
    }

    void dfsTopSort(int src, HashMap<Integer, Boolean> visited, Stack <Integer> st){
        visited.put(src,true);
        System.out.println(src);

        if (adjList.containsKey(src)){
            for (int nbr : adjList.get(src)){
                if (!visited.get(nbr)){
                    dfsTopSort(nbr,visited,st);
                }

            }
        }
        st.add(src);
    }
    void shortcutPathbfs(int src, int dest){
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,Boolean> visited = new HashMap<>();
        HashMap<Integer,Integer> parent = new HashMap<>();

        // Initialize visited and parent maps
        for (int node : adjList.keySet()) {
            visited.put(node, false);
        }

        q.add(src);
        visited.put(src, true);
        parent.put(src,-1);
        while (!q.isEmpty()){
            int frontNode = q.remove();

            if (adjList.containsKey(frontNode)){
                for (Integer nbr : adjList.get(frontNode)){
                    if (visited.containsKey(nbr)&&!visited.get(nbr)){
                        q.add(nbr);
                        parent.put(nbr,frontNode);
                        visited.put(nbr,true);
                    }
                }
            }

        }

        // Reconstruct path from destination to source
        ArrayList<Integer> ans = new ArrayList<>();
        int current = dest;
        while (current != -1) {
            ans.add(current);
            current = parent.get(current);
        }
        Collections.reverse(ans);

// Include the source node in the output path
        if (!ans.isEmpty() && ans.get(0) == src) {
            System.out.println("Shortest path from source to destination: " + ans);
        } else {
            System.out.println("No path exists from source to destination.");
        }

    }
}
public class shortCutPath {
    public static void main(String[] args) {

        gph g = new gph();
        g.addEdge(0,5,false);
        g.addEdge(5,4,false);
        g.addEdge(4,3,false);
        g.addEdge(0,6,false);
        g.addEdge(6,3,false);
        g.addEdge(0,1,false);
        g.addEdge(1,2,false);
        g.addEdge(2,3,false);

        g.print();
        System.out.println("printing shortest path");
        g.shortcutPathbfs(0,3);


    }
}
