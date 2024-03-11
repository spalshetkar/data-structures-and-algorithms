package graph;

import java.util.*;

public class IsItATree {
    Boolean is_it_a_tree(Integer node_count, List<Integer> edge_start, List<Integer> edge_end) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < edge_start.size(); i++) edges.add(Arrays.asList(edge_start.get(i), edge_end.get(i)));

        // Creating adjacency list from edge list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < node_count; i++) adjList.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int src = edge.get(0);
            int dst = edge.get(1);

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[] visited = new int[node_count];
        Arrays.fill(visited, -1);

        // Parent array to keep track of parent nodes
        int[] parent = new int[node_count];
        Arrays.fill(parent, -1);

        // Check for number of components and check if dfs/bfs has no cycles (Traversing the graph)
        int components = 0;
        boolean check = true;
        for(int i = 0; i < node_count; i++) {
            if(visited[i] == -1) {
                check = bfs(adjList, visited, parent, i);
                // dfs(adjList, visited, parent, i);
                components++;
            }
        }

        return check && components == 1;
    }

    private boolean bfs(List<List<Integer>> adjList, int[] visited, int[] parent, int index) {
        Queue<Integer> queue = new LinkedList<>();
        visited[index] = 1;
        queue.add(index);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for(int node : adjList.get(curr)) {
                // Tree edge found
                if(visited[node] == -1) {
                    parent[node] = curr;
                    visited[node] = 1;
                    queue.add(node);
                }
                else {
                    // Cross edge found
                    if(parent[curr] != node) return false;
                    // Parent edge found
                    else continue;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int[] visited, int[] parent, int index) {
        visited[index] = 1;

        for(int node : adjList.get(index)) {
            // Tree node found
            if(visited[node] == -1) {
                parent[node] = index;
                dfs(adjList, visited, parent, node);
            }
            else {
                // Back edge found
                if(parent[index] != node) return false;
                // Parent edge found
                else continue;
            }
        }

        return true;
    }
}
