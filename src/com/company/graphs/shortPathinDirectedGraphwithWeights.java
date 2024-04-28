package com.company.graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class gp{
    HashMap<Integer, ArrayList<HashMap<Integer,Integer>>> adjList = new HashMap<>();

    void addEdge(int u , int v , int weight , Boolean direction){
        if (direction){
            if (!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            HashMap<Integer,Integer> pair = new HashMap<>();
            pair.put(v,weight);
            adjList.get(u).add(pair);
        }else{
            if (!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            HashMap<Integer,Integer> pair = new HashMap<>();
            pair.put(v,weight);
            adjList.get(u).add(pair);
            if (!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            pair = new HashMap<>();
            pair.put(u,weight);
            adjList.get(v).add(pair);
        }
    }

    void print(){
        for (HashMap.Entry<Integer,ArrayList<HashMap<Integer,Integer>>> entry : adjList.entrySet()){
            System.out.print(entry.getKey()+" -> ");
            ArrayList<HashMap<Integer,Integer>> nbr = entry.getValue();
            for(int i = 0; i < nbr.size(); i++){
                System.out.print(nbr.get(i)+" ");
            }
            System.out.println();
        }
    }

    void topoSort(int src, HashMap<Integer, Boolean> visited, Stack<Integer> st){
        visited.put(src,true);

        if (adjList.containsKey(src)){
            for (HashMap <Integer,Integer>i  : adjList.get(src)){
               for (int nbr : i.keySet()){
                   if (!visited.get(nbr)){
                       topoSort(nbr,visited,st);
                   }
               }
            }
        }
        st.add(src);
    }

    void shortestPathDfs(int dest, Stack<Integer> st,int n){

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int src = st.pop();
        dist[src] = 0;

        //update nbr distance for this src node
        if (adjList.containsKey(src)){
            for (HashMap<Integer, Integer> nbr : adjList.get(src) ){
                for (int nbrs : nbr.keySet()){
                    int nbrNode = nbrs;
                    int nbrDist = nbr.get(nbrs);

                    if (dist[src] + nbrDist < dist[nbrNode]){
                        dist[nbrNode] = dist[src] + nbrDist;
                    }
                }
            }
        }

        // apply same concept for all remainng nodes

        while (!st.isEmpty()){
             src = st.pop();

             if (adjList.containsKey(src)){
                 for (HashMap<Integer, Integer> nbr : adjList.get(src) ){
                     for (int nbrs : nbr.keySet()){
                         int nbrNode = nbrs;
                         int nbrDist = nbr.get(nbrs);

                         if (dist[src] + nbrDist < dist[nbrNode]){
                             dist[nbrNode] = dist[src] + nbrDist;
                         }
                     }
                 }
             }

        }


        // ab mera distance array tyaar hai

        System.out.println("Shortest Path");
        for (int i = 0 ; i < dist.length; i++){
            System.out.print(dist[i]+ " ");
        }
    }
}
public class shortPathinDirectedGraphwithWeights {
    public static void main(String[] args) {

        gp g = new gp();
        g.addEdge(0,1,5,true);
        g.addEdge(0,2,3,true);
        g.addEdge(2,1,2,true);
        g.addEdge(1,3,3,true);
        g.addEdge(2,3,5,true);
        g.addEdge(2,4,6,true);
        g.addEdge(4,3,1,true);
        g.print();

        HashMap<Integer,Boolean> visited = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i<7; i++){
            visited.put(i,false);
        }

        g.topoSort(0,visited,st);


        g.shortestPathDfs(0,st,5);
    }
}
