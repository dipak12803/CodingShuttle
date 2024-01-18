package classCoding;


import java.util.*;
class Graph {
    private int numVertices; // Number of vertices in graph
    private LinkedList<Integer> adjLists[]; // Adjacency Lists
    private boolean visited[]; // Array to check if a node has been visited or not
    // Constructor
    Graph(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];
        // Initialize adjacency lists for all the vertices
        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }
    // Function to add an edge into the graph
    void addEdge(int src, int dest) {
        adjLists[src].add(dest); // Add an edge from src to dest.
        adjLists[dest].add(src); // Since graph is undirected, add an edge from dest to src also
    }
    // A function used by DFS
    void DFS(int vertex, int goal) {
        // Mark the current node as visited and print it
        visited[vertex] = true;
        System.out.print(vertex + " ");
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj, goal);
            // If the goal node is found, print a message and terminate the program
            if(adj == goal) {
                System.out.println();
                System.out.println("Goal Node Found!");
                System.exit(0);
            }
        }
    }
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("DFS traversal starting from node 0:");
        g.DFS(0, 4); // Perform DFS starting from node 0 and find path to node 4
    }
}

