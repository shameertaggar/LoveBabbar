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
        Queue<Integer> q  = new LinkedList<>();
        HashMap<Integer,Boolean> vis = new HashMap<>();
        HashMap<Integer,Integer> parent = new HashMap<>();
        vis.put(src,true);
        parent.put(src,-1);
        q.add(src);

        for (int i = 0; i< adjList.size(); i++){
            vis.put(i,false);
        }
        while(!q.isEmpty()){
            int vertex = q.remove();
            for(int key : adjList.get(vertex)){
                if (!vis.get(key)){
                    q.add(key);
                    vis.put(key,true);
                    parent.put(key,vertex);
                }
            }
        }


        List<Integer> ans = new ArrayList<>();
        ans.add(dest);
        int val = -1;
        while(val != src){
            val = parent.get(dest);
            ans.add(val);
            dest = val;
        }

        Collections.reverse(ans);
        System.out.println(ans);
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
