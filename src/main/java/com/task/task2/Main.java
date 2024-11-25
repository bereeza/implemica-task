package com.task.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        scanner.nextLine();

        // number of cities
        int n = scanner.nextInt();
        scanner.nextLine();

        while (s > 0) {
            Map<String, Integer> cities = new HashMap<>();
            int[][] matrix = new int[n][n];

            // read city data (name and neighbors)
            for (int i = 0; i < n; i++) {
                String city = scanner.nextLine();
                cities.put(city, i);

                // number of neighboring cities
                int p = scanner.nextInt();
                for (int j = 0; j < p; j++) {
                    int nr = scanner.nextInt() - 1;
                    int cost = scanner.nextInt();
                    matrix[i][nr] = cost;
                }
                scanner.nextLine();
            }

            Dijkstra dijkstra = new Dijkstra(matrix);

            // number of paths to find
            int r = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < r; i++) {
                String startCity = scanner.next();
                String endCIty = scanner.next();

                // find city indices
                int start = cities.get(startCity);
                int end = cities.get(endCIty);

                // calculate distance between start city and end city
                int cost = dijkstra.getShortestPath(start, end);
                System.out.println(cost);
            }

            s--;
        }

        scanner.close();
    }
}
