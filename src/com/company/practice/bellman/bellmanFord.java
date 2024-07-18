import java.util.*;

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
    HashMap<Integer, List<Edge>> edges;

    public Graph() {
        edges = new HashMap<>();
    }

    void addEdge(int u, int v, int wt) {
        Edge e1 = new Edge(u, v, wt);
        if (!edges.containsKey(u)) {
            edges.put(u, new ArrayList<>());
        }
        edges.get(u).add(e1);
    }

    void print() {
        for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
            List<Edge> nbr = entry.getValue();
            if (nbr != null) {
                for (Edge e : nbr) {
                    System.out.println(e.u + " connected with " + e.v + " (" + e.wt + ")");
                }
            }
        }
    }

    void bellmannFord(int src) {
        int n = edges.size();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // n-1 times relaxation
        for (int i = 1; i < n; i++) {
            for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
                List<Edge> nbr = entry.getValue();
                if (nbr != null) {
                    for (Edge e : nbr) {
                        int u = e.u;
                        int v = e.v;
                        int wt = e.wt;
                        if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                            dist[v] = dist[u] + wt;
                        }
                    }
                }
            }
        }

        boolean update = false;
        for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
            List<Edge> nbr = entry.getValue();
            for (Edge e : nbr) {
                int u = e.u;
                int v = e.v;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    update = true;
                    dist[v] = dist[u] + wt;
                    break;
                }
            }
        }

        if (update) {
            System.out.println("-ve cycle is present");
        } else {
            System.out.println("Printing distance array:");
            System.out.println("Vertex     Distance");
            for (int i = 1; i < dist.length; i++) {
                System.out.println(i + "            " + dist[i]);
            }
        }
    }

    void floydWarshall(int n) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 1000000000);
            dist[i][i] = 0;
        }

        // Update weights based on the given graph edges
        for (Map.Entry<Integer, List<Edge>> entry : edges.entrySet()) {
            List<Edge> nbr = entry.getValue();
            for (Edge e : nbr) {
                int u = e.u;
                int v = e.v;
                int wt = e.wt;
                dist[u][v] = wt;
            }
        }

        // Main helper logic
        for (int helper = 0; helper < n; helper++) {
            for (int src = 0; src < n; src++) {
                for (int dest = 0; dest < n; dest++) {
                    if (dist[src][helper] < 1000000000 && dist[helper][dest] < 1000000000) {
                        dist[src][dest] = Math.min(dist[src][dest], dist[src][helper] + dist[helper][dest]);
                    }
                }
            }
        }

        // Print distance array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == 1000000000) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

public class bellmanFord {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2, -1);
        g.addEdge(2, 5, 3);
        g.addEdge(4, 5, 5);
        g.addEdge(1, 5, 4);
        g.addEdge(4, 2, 1);
        g.addEdge(2, 3, 3);
        g.addEdge(3, 4, -3);
        g.addEdge(5, 1, 1);

        g.print();
        g.bellmannFord(1);

        g = new Graph();
        g.addEdge(0, 1, 3);
        g.addEdge(1, 0, 2);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 4);
        g.addEdge(3, 2, 2);
        g.addEdge(2, 1, 1);

        g.floydWarshall(4);
    }
}
