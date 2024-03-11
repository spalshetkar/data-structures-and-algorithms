package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleDirectedGraph {
    public Boolean has_cycle(Integer number_of_vertices, Integer number_of_edges, List<List<Integer>> edges) {
        // Creating adjacency list from edge list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < number_of_vertices; i++) adjList.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int src = edge.get(0);
            int dst = edge.get(1);

            adjList.get(src).add(dst);
        }

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[] visited = new int[number_of_vertices];
        Arrays.fill(visited, -1);

        // Arrival and departure arrays to keep track of arrival/departure time to detect back, forward and cross edges
        int[] time = new int[]{0};
        int[] arrival = new int[number_of_vertices];
        int[] departure = new int[number_of_vertices];
        Arrays.fill(arrival, -1);
        Arrays.fill(departure, -1);

        for(int i = 0; i < number_of_vertices; i++) {
            if(visited[i] == -1) {
                // If cycle detected then return true
                if(dfs(adjList, visited, arrival, departure, time, i)) return true;
            }
        }

        return false;
    }

    private boolean dfs(List<List<Integer>> adjList, int[] visited, int[] arrival, int[] departure, int[] time, int node) {
        visited[node] = 1;
        arrival[node] = time[0]++;

        for(Integer neighbor : adjList.get(node)) {
            // Tree node found
            if(visited[neighbor] == -1) {
                // If cycle detected in the neighbors then return true
                if (dfs(adjList, visited, arrival, departure, time, neighbor)) return true;
            }
            else {
                // Back edge found
                if(departure[neighbor] == -1) return true;
                    // Forward node or Cross node found
                else continue;
            }
        }

        departure[node] = time[0]++;

        return false;
    }
}
