package com.company.graphs;


import java.util.*;

class gphh{
    HashMap<Integer, ArrayList<HashMap<Integer,Integer>>> adjList = new HashMap<>();



    void addEdge(int u , int v , int weight , boolean direction){
        if (!adjList.containsKey(u)){
            adjList.put(u,new ArrayList<>());
        }
        HashMap<Integer,Integer> pair = new HashMap<>();
        pair.put(v,weight);
        adjList.get(u).add(pair);
        if (!direction){
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
            ArrayList<HashMap<Integer, Integer>> nbr = entry.getValue();
            for (int i = 0; i < nbr.size(); i++){
                System.out.print(nbr.get(i)+" ");
            }
            System.out.println();
        }
    }
      void dijkstraShortestPath(int n, int[] dist, TreeMap<Integer, Integer> set,int src, int dest) {
        Arrays.fill(dist,Integer.MAX_VALUE);
        set.put(0,src);
        dist[src] = 0;

        while (!set.isEmpty()){
            int topElement = set.pollFirstEntry().getValue();
//            if (topElement == dest){
//                break;
//            }
            if (adjList.containsKey(topElement)){
                for (HashMap<Integer,Integer> nbr : adjList.get(topElement)){
                    for (int nbrVertex : nbr.keySet()){
                        int wt = nbr.get(nbrVertex);

                        if (dist[topElement] + wt < dist[nbrVertex]){
                            dist[nbrVertex] = dist[topElement] + wt;
                            System.out.println("nbrVertex : " + nbrVertex+" weight : "+dist[nbrVertex]);
                            set.put(dist[nbrVertex], nbrVertex);
                        }
                    }
                }
            }
        }
          System.out.println("Dijkstra Algorithm");
          // Print the result if needed
          System.out.println("Shortest distances from source vertex:");
          for (int i = 0; i < dist.length; i++) {
              System.out.println("Vertex " + i + ": " + dist[i]);
          }

          // Print the shortest distance to the destination vertex
          System.out.println("Shortest distance to destination vertex " + dest + ": " + dist[dest]);
    }


}
public class dijkstra {
    public static void main(String[] args) {

        int n = 7;
        int dist[] = new int[n];
        TreeMap<Integer,Integer> set = new TreeMap<>();

        gphh g = new gphh();
        g.addEdge(6,5,9,false);
        g.addEdge(6,3,2,false);
        g.addEdge(6,1,14,false);
        g.addEdge(5,4,6,false);
        g.addEdge(3,4,11,false);
        g.addEdge(3,2,10,false);
        g.addEdge(1,2,7,false);
        g.addEdge(1,3,9,false);
        g.addEdge(2,4,15,false);
        g.dijkstraShortestPath(n,dist,set,6,1);
    }

}
