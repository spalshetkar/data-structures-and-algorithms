package graph;

import java.util.*;

public class ZombieClusters {
    public Integer zombie_cluster(List<String> zombies) {
        // Creating adjacency list from edge list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < zombies.size(); i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < zombies.size(); i++) {
            for(int j = 0; j < zombies.get(i).length(); j++) {
                int c = Character.getNumericValue(zombies.get(i).charAt(j));

                int src = i;
                int dst = j;

                if(c == 1 && i != j) adjList.get(src).add(dst);
            }
        }

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[] visited = new int[zombies.size()];
        Arrays.fill(visited, -1);

        // Check for number of components
        int components = 0;

        for(int i = 0; i < zombies.size(); i++) {
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
