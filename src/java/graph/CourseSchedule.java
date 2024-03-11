package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CourseSchedule {
    List<Integer> course_schedule(Integer n, List<List<Integer>> prerequisites) {
        // Creating adjacency list from edge list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (List<Integer> edge : prerequisites) {
            int src = edge.get(0);
            int dst = edge.get(1);

            // We're reversing this because dst needs to be completed to start src course. Therefore dst -> src
            adjList.get(dst).add(src);
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

        // Topological sorted list for Directed Acyclic Graph (DAG)
        List<Integer> topSort = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(visited[i] == -1) {
                if(!dfs(adjList, visited, arrival, departure, time, topSort, i)) return new ArrayList<>();
            }
        }

        Collections.reverse(topSort);
        return topSort;
    }

    private boolean dfs(List<List<Integer>> adjList, int[] visited, int[] arrival, int[] departure, int[] time, List<Integer> topSort, int node) {
        visited[node] = 1;
        arrival[node] = time[0]++;

        for(Integer neighbor : adjList.get(node)) {
            // Tree node found
            if(visited[neighbor] == -1) {
                if (!dfs(adjList, visited, arrival, departure, time, topSort, neighbor)) return false;
            }
            else {
                // Back edge found
                if(departure[neighbor] == -1) return false;
                    // Forward node or Cross node found
                else continue;
            }
        }

        departure[node] = time[0]++;

        topSort.add(node);

        return true;
    }
}
