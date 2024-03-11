package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestPathWeightedDAG {
    List<Integer> find_longest_path(Integer dag_nodes, List<Integer> dag_from, List<Integer> dag_to, List<Integer> dag_weight, Integer from_node, Integer to_node) {
        // Creating weighted adjacency list from edge list
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= dag_nodes; i++) adjList.add(new ArrayList<>());
        for(int i = 0; i < dag_from.size(); i++) {
            int src = dag_from.get(i);
            int dst = dag_to.get(i);
            int weight = dag_weight.get(i);

            adjList.get(src).add(new int[]{dst, weight});
        }

        // Find topological sorted list of DAG to later on traverse from the root node to the children nodes
        List<Integer> topSort = findTopSort(adjList, dag_nodes);

        // To keep track of logest path from from_node to the ith node
        long[] longestPath = new long[dag_nodes + 1];
        Arrays.fill(longestPath, -1);
        longestPath[from_node] = 0;

        // To keep track of the logest path parent node of any arbitrary node 'i' to recreate the final result at the end
        int[] parent = new int[dag_nodes + 1];
        Arrays.fill(parent, -1);

        // Traverse in topological sorted order to assign parent to each node with respect to the longest path
        for(int i = 0; i < topSort.size(); i++) {
            int from = topSort.get(i);

            if(longestPath[from] >= 0) {
                if(from == to_node) break;

                for(int j = 0; j < adjList.get(from).size(); j++) {
                    int to = adjList.get(from).get(j)[0];
                    int weight = adjList.get(from).get(j)[1];

                    if(longestPath[to] <= longestPath[from] + weight) {
                        longestPath[to] = longestPath[from] + weight;

                        parent[to] = from;
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int to = to_node;
        result.add(to);

        while(to != from_node) {
            to = parent[to];
            result.add(to);
        }

        Collections.reverse(result);
        return result;
    }

    private static List<Integer> findTopSort(List<List<int[]>> adjList, int n) {
        // Visited array to keep track of visited nodes and avoid infinite loop
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        // Arrival and departure arrays to keep track of arrival/departure time to detect back, forward and cross edges
        int[] time = new int[]{0};
        int[] arrival = new int[n + 1];
        int[] departure = new int[n + 1];
        Arrays.fill(arrival, -1);
        Arrays.fill(departure, -1);

        // Topological sorted list for Directed Acyclic Graph (DAG)
        List<Integer> topSort = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(visited[i] == -1) {
                dfs(adjList, visited, arrival, departure, time, topSort, i);
            }
        }

        Collections.reverse(topSort);
        return topSort;
    }

    private static void dfs(List<List<int[]>> adjList, int[] visited, int[] arrival, int[] departure, int[] time, List<Integer> topSort, int node) {
        visited[node] = 1;
        arrival[node] = time[0]++;

        for(int[] neighbor : adjList.get(node)) {
            // Tree node found
            if(visited[neighbor[0]] == -1) {
                dfs(adjList, visited, arrival, departure, time, topSort, neighbor[0]);
            }
            else {
                // Back edge found
                if(departure[neighbor[0]] == -1) continue;
                    // Forward node or Cross node found
                else continue;
            }
        }

        departure[node] = time[0]++;

        topSort.add(node);

        return;
    }
}
