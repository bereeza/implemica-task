package com.task.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Class to calculate the shortest path using Dijkstra's algorithm
 *
 */
public class Dijkstra {

    // adjacency matrix (our graph)
    private final int[][] adjMatrix;

    // number of vertices in graph
    private final int vertices;

    Dijkstra(int[][] matrix) {
        // If we have null matrix => throw illegal argument exception
        if (matrix == null) {
            throw new IllegalArgumentException("The matrix cannot be null.");
        }
        this.adjMatrix = matrix;
        this.vertices = matrix.length;
    }

    /**
     * Compute the shortest path between two vertices (start vertex and end vertex) using Dijkstra's algorithm
     *
     * @param startVertex - index of the start vertex
     * @param endVertex - index of the end vertex
     * @return - shortest path between two vertex
     */
    public int getShortestPath(int startVertex, int endVertex) {
        // shortest distance to each vertex
        int[] dist = new int[vertices];

        // array to store if a vertex has been visited
        boolean[] isVisited = new boolean[vertices];

        // fill all array by MAX_VALUE (2147483647)
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startVertex] = 0;

        for (int i = 0; i < vertices; i++) {

            // get the nearest unvisited vertex
            int nearestVertex = getMinVertex(dist, isVisited);
            // if we have no vertex => break
            if (nearestVertex == -1) {
                break;
            }

            // mark vertex as visited
            isVisited[nearestVertex] = true;

            // update the distances
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[nearestVertex][j] > 0 && !isVisited[j]
                        && dist[nearestVertex] + adjMatrix[nearestVertex][j] < dist[j]) {
                    dist[j] = dist[nearestVertex] + adjMatrix[nearestVertex][j];
                }
            }
        }

        return dist[endVertex];
    }

    /**
     * Compute the vertex with the minimum distance from start vertex
     *
     * @param dist - arr of distances to each vertex
     * @param isVisited - tracking if a vertex has been visited
     * @return - the index of the vertex with minimim distance
     */
    private int getMinVertex(int[] dist, boolean[] isVisited) {
        return IntStream.range(0, vertices)
                .filter(i -> !isVisited[i])     // filter our visited vertex
                .boxed()                        // int -> Integer, for Comparator method
                .min(Comparator.comparingInt(i -> dist[i]))
                .orElse(-1);
    }
}
