package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {
    List<List<Integer>> find_critical_connections(int number_of_servers, List<List<Integer>> connections) {
        // Create an adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < number_of_servers; i++) adjList.add(new ArrayList<>());
        for(List<Integer> connection : connections) {
            int src = connection.get(0);
            int dst = connection.get(1);

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[] visited = new int[number_of_servers];
        Arrays.fill(visited, -1);

        // Parent array to keep track of parent nodes
        int[] parent = new int[number_of_servers];
        Arrays.fill(parent, -1);

        // Arrival and departure arrays to keep track of arrival/departure time to detect back, forward and cross edges
        int[] time = new int[]{0};
        int[] arrival = new int[number_of_servers];
        int[] departure = new int[number_of_servers];
        Arrays.fill(arrival, -1);
        Arrays.fill(departure, -1);

        // To keep track of the lowest arrival time for each node, we would need another array
        int[] lowestArrivalTime = new int[number_of_servers];
        Arrays.fill(lowestArrivalTime, Integer.MAX_VALUE);

        List<List<Integer>> result = new ArrayList<>();

        dfs(adjList, visited, parent, arrival, departure, time, lowestArrivalTime, 0, result);

        return result;
    }

    private int dfs(List<List<Integer>> adjList, int[] visited, int[] parent, int[] arrival, int[] departure, int[] time, int[] lowestArrivalTime, int node, List<List<Integer>> result) {
        visited[node] = 1;
        arrival[node] = time[0]++;
        lowestArrivalTime[node] = arrival[node];

        for(Integer neighbor : adjList.get(node)) {
            // Tree edge found
            if(visited[neighbor] == -1) {
                parent[neighbor] = node;

                // Check for the lowest arrival time found from the subtree of the neighbor
                int lowest = dfs(adjList, visited, parent, arrival, departure, time, lowestArrivalTime, neighbor, result);
                lowestArrivalTime[node] = Math.min(lowestArrivalTime[node], lowest);
            }
            else {
                // Back edge found - meaning, there is a path from that node to an ancestor who is not the immediate parent. Therefore, not a bridge edge (not a critical connection)
                if(neighbor != parent[node]) {
                    lowestArrivalTime[node] = Math.min(lowestArrivalTime[node], arrival[neighbor]);
                }
            }
        }

        departure[node] = time[0]++;

        // If node is not root node (not 0) and if the lowestArrivalTime of the node is same as it's arrival time then it is a bridge edge (critical connection)
        if(lowestArrivalTime[node] == arrival[node] && node != 0) result.add(Arrays.asList(node, parent[node]));

        return lowestArrivalTime[node];
    }
}
