package com.company.graphs;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.lang.reflect.Array;
import java.security.Key;
import java.sql.Struct;
import java.util.*;

class g{
    HashMap<Character, ArrayList<HashMap<Character,Integer>>> adjList = new HashMap<>();
    void addEdge(char u, char v, int wt, boolean direction){
        if (!adjList.containsKey(u)){
            adjList.put(u,new ArrayList<>());
        }
        HashMap<Character,Integer> pair = new HashMap<>();
        pair.put(v,wt);
        adjList.get(u).add(pair);
        if (!direction){
            if (!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            pair = new HashMap<>();
            pair.put(u,wt);
            adjList.get(v).add(pair);
        }
    }

    void print(){
        adjList.forEach((key, value) -> {
            System.out.print(key +" -> ");
            ArrayList<HashMap<Character,Integer>> nbr = value;
            for (int i = 0 ; i < nbr.size(); i++){
                System.out.print(nbr.get(i)+" ");
            }
            System.out.println();
        });
    }

    void belman(int n , int src){
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src-'A'] = 0;
        // n-1 times relaxation


        for (int i = 1; i < n; i++) {

            adjList.forEach((u, value) -> {
                for (HashMap<Character, Integer> pair : value) {
                    char v = pair.keySet().iterator().next();
                    int weight = pair.get(v);
                    if (dist[u - 'A'] != Integer.MAX_VALUE && dist[u - 'A'] + weight < dist[v - 'A']) {

                        dist[v - 'A'] = dist[u - 'A'] + weight;
                    }
                }
            });


            boolean anyUpdate[] = {false};
            adjList.forEach((u, value) -> {
                for (HashMap<Character, Integer> pair : value) {
                    char v = pair.keySet().iterator().next();
                    int weight = pair.get(v);
                    if (dist[u - 'A'] != Integer.MAX_VALUE && dist[u - 'A'] + weight < dist[v - 'A']) {
                        anyUpdate[0] = true;
                        dist[v - 'A'] = dist[u - 'A'] + weight;
                    }
                }
            });

            if (anyUpdate[0] == true){
                System.out.println("Negative cycle is present");
            }else{
                System.out.println("No negative cycleis present");
            }
        }



        // Print the distances
        for (char vertex : adjList.keySet()) {
            System.out.println("Distance from " + src + " to " + vertex + ": " + dist[vertex - 'A']);
        }

        for (int i = 0; i < dist.length; i++){
            System.out.print(dist[i]+ " ");
        }
    }
}
public class bellmanFord {
    public static void main(String[] args) {
        g q = new g();
        q.addEdge('A','B',-1,true);
        q.addEdge('B','E',2,true);
        q.addEdge('E','D',-3,true);
        q.addEdge('D','C',5,true);
        q.addEdge('A','C',4,true);
        q.addEdge('B','C',3,true);
        q.addEdge('B','D',2,true);
        q.addEdge('D','B',1,true);

        q.print();
        q.belman(5,'A');
    }
}
