package graph;

import java.util.*;

public class CountConnectedComponentsUndirectedGraph {
    Integer number_of_connected_components(Integer n, List<List<Integer>> edges) {
        // Creating adjacency list from edge list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int src = edge.get(0);
            int dst = edge.get(1);

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        // Check for number of components
        int components = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == -1) {
                bfs(adjList, visited, i);
                // dfs(adjList, visited, i);
                components++;
            }
        }

        return components;
    }

    private void bfs(List<List<Integer>> adjList, int[] visited, int index) {
        Queue<Integer> queue = new LinkedList<>();
        visited[index] = 1;
        queue.add(index);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for(int nodes : adjList.get(curr)) {
                if(visited[nodes] == -1) {
                    visited[nodes] = 1;
                    queue.add(nodes);
                }
            }
        }

        return;
    }

    private void dfs(List<List<Integer>> adjList, int[] visited, int index) {
        visited[index] = 1;

        for(int nodes : adjList.get(index)) {
            if(visited[nodes] == -1) dfs(adjList, visited, nodes);
        }

        return;
    }
}
