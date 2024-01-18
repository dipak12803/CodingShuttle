package classCoding;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        int[][] graph = {{0, 4, 0, 0, 0, 0},
                {4, 0, 2, 0, 0, 0},
                {0, 2, 0, 3, 0, 0},
                {0, 0, 3, 0, 5, 0},
                {0, 0, 0, 5, 0, 10},
                {0, 0, 0, 0, 10, 0}};

        int source = 0;

        // Initialize distances from the source vertex
        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Create a priority queue to store the vertices that are not yet visited
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(new Vertex(source, 0));

        // While the queue is not empty
        while (!queue.isEmpty()) {
            // Get the vertex with the shortest distance from the source
            Vertex currentVertex = queue.poll();

            // If the current vertex is the destination, we are done
            if (currentVertex.index == graph.length - 1) {
                break;
            }

            // For each neighbor of the current vertex
            for (int neighborIndex = 0; neighborIndex < graph[currentVertex.index].length; neighborIndex++) {
                if (graph[currentVertex.index][neighborIndex] > 0) {
                    // Calculate the distance from the source to the neighbor through the current vertex
                    int newDistance = currentVertex.distance + graph[currentVertex.index][neighborIndex];

                    // If the new distance is shorter than the current distance to the neighbor, update the distance
                    if (newDistance < distances[neighborIndex]) {
                        distances[neighborIndex] = newDistance;

                        // Add the neighbor to the priority queue if it is not already there
                        if (!queue.contains(new Vertex(neighborIndex, newDistance))) {
                            queue.add(new Vertex(neighborIndex, newDistance));
                        }
                    }
                }
            }
        }

        // Print the shortest distances from the source to all other vertices
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance from source to vertex " + i + ": " + distances[i]);
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        int index;
        int distance;

        Vertex(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex other) {
            return this.distance - other.distance;
        }
    }
}
