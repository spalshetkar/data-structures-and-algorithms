package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompleteAllCourses {
    Boolean can_be_completed(Integer n, List<Integer> a, List<Integer> b) {
        // Creating adjacency list from edge list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < a.size(); i++) {
            int src = a.get(i);
            int dst = b.get(i);

            adjList.get(src).add(dst);
        }

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        // Arrival and departure arrays to keep track of arrival/departure time to detect back, forward and cross edges
        int[] time = new int[]{0};
        int[] arrival = new int[n];
        int[] departure = new int[n];
        Arrays.fill(arrival, -1);
        Arrays.fill(departure, -1);

        for(int i = 0; i < n; i++) {
            if(visited[i] == -1) {
                if(!dfs(adjList, visited, arrival, departure, time, i)) return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int[] visited, int[] arrival, int[] departure, int[] time, int node) {
        visited[node] = 1;
        arrival[node] = time[0]++;

        for(Integer neighbor : adjList.get(node)) {
            // Tree node found
            if(visited[neighbor] == -1) {
                if (!dfs(adjList, visited, arrival, departure, time, neighbor)) return false;
            }
            else {
                // Back edge found
                if(departure[neighbor] == -1) return false;
                // Forward node or Cross node found
                else continue;
            }
        }

        departure[node] = time[0]++;

        return true;
    }
}
