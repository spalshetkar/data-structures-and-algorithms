package graph;

import java.util.*;

public class BipartiteGraph {
    Boolean can_be_divided(Integer num_of_people, List<Integer> dislike1, List<Integer> dislike2) {
        int node_count = num_of_people;
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < dislike1.size(); i++) edges.add(Arrays.asList(dislike1.get(i), dislike2.get(i)));

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

        // Color array to differentiate nodes between two groups
        int[] color = new int[node_count];
        Arrays.fill(color, -1);

        // Check if dfs/bfs has no cycles (Traversing the graph)
        boolean check = true;
        for(int i = 0; i < node_count; i++) {
            if(visited[i] == -1) {
                color[i] = 0;
                // check = bfs(adjList, visited, parent, color, i);
                check = dfs(adjList, visited, parent, color, i);
            }
        }

        return check;
    }

    private boolean bfs(List<List<Integer>> adjList, int[] visited, int[] parent, int[] color, int index) {
        Queue<Integer> queue = new LinkedList<>();
        visited[index] = 1;
        queue.add(index);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for(int node : adjList.get(curr)) {
                // Tree edge found
                if(visited[node] == -1) {
                    visited[node] = 1;
                    parent[node] = curr;
                    color[node] = 1 - color[curr];

                    queue.add(node);
                }
                else {
                    // Cross edge found
                    if(parent[curr] != node) {
                        // Odd cycle found (Both nodes are in the same group)
                        if(color[curr] == color[node]) return false;
                        // Even cycle found (Both nodes are in different group)
                        else continue;
                    }
                    // Parent edge found
                    else continue;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int[] visited, int[] parent, int[] color, int index) {
        visited[index] = 1;

        for(int node : adjList.get(index)) {
            // Tree node found
            if(visited[node] == -1) {
                parent[node] = index;
                color[node] = 1 - color[index];
                dfs(adjList, visited, parent, color, node);
            }
            else {
                // Back edge found
                if(parent[index] != node) {
                    // Odd cycle found (Both nodes are in the same group)
                    if(color[node] == color[index]) return false;
                    // Even cycle found (Both nodes are in different group)
                    else continue;
                }
                // Parent edge found
                else continue;
            }
        }

        return true;
    }
}
