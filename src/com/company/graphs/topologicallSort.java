package com.company.graphs;




import java.util.*;

class grph{
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
        System.out.println("Printing Graph");

        for (HashMap.Entry<Integer,ArrayList<Integer>> entry : adjList.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            ArrayList<Integer> neighbour = entry.getValue();
           for (int i = 0; i < neighbour.size(); i++){
               System.out.print(neighbour.get(i));
               if (i < neighbour.size() - 1) {
                   System.out.print(", ");
               }
           }
            System.out.println();
        }
    }
    void topSortdfs(int src, HashMap<Integer, Boolean> visited,Stack<Integer> st){
        visited.put(src,true);
        System.out.println(src);

        if (adjList.containsKey(src)){
            for (Integer nbr : adjList.get(src)){
                if (!visited.get(nbr)){
                    topSortdfs(nbr,visited,st);
                }
            }
            st.push(src);
        }else{
            st.push(src);
        }

    }

    void topSortBfs(int n){
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        // Calculate indegree for each vertex
        for (ArrayList<Integer> neighbors : adjList.values()) {
            for (int neighbor : neighbors) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        // Print the calculated indegrees (optional)
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            System.out.println("Vertex: " + entry.getKey() + ", Indegree: " + entry.getValue());
        }

        //push all zero indegree nodes in queue

        for (int node = 0; node < n; node++){
            if (indegree.getOrDefault(node, 0) == 0) {
                q.add(node);
            }
        }

        //BFS chlaate hai

        while (!q.isEmpty()){
            int frontNode = q.remove();
            System.out.print(frontNode + " , ");

            if (adjList.containsKey(frontNode)){
                for (Integer i : adjList.get(frontNode)) {
              //      System.out.println("frontNode : " +i );
                    indegree.put(i, indegree.get(i) - 1);
                    if (indegree.get(i) == 0) {
                        q.add(i);
                    }
                }
            }


        }
    }
}
public class topologicallSort {
    public static void main(String[] args) {
        HashMap<Integer,Boolean> visited = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<=7; i++){
            visited.put(i,false);
        }
        grph g = new grph();
        int node = 8;
        g.addEdge(0,1,true);
        g.addEdge(1,2,true);
        g.addEdge(2,3,true);
        g.addEdge(3,4,true);
        g.addEdge(3,5,true);
        g.addEdge(5,6,true);
        g.addEdge(6,7,true);
        g.addEdge(4,6,true);

        g.print();

        for (int i = 0; i<node-1; i++){
            if (!visited.get(i)){
                System.out.println("visiting");
                g.topSortdfs(i,visited,st);
            }
        }
        System.out.println("\nTopological Sort DFS");
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }

        System.out.println("\n\n");

        grph h = new grph();
        h.addEdge(0,1,true);
        h.addEdge(1,2,true);
        h.addEdge(2,3,true);
        h.addEdge(2,4,true);
        h.addEdge(3,5,true);
        h.addEdge(4,5,true);
        h.addEdge(5,6,true);
        h.addEdge(5,7,true);



        int n = 8;
        h.print();
        h.topSortBfs(n);



    }
}
