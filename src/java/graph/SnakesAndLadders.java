package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakesAndLadders {
    Integer minimum_number_of_rolls(Integer n, List<Integer> moves) {
        // Same use case as visited array to check if node is already traversed or not and to avoid infinite loop
        int[] distance = new int[n];
        for(int i = 0; i < n; i++) distance[i] = -1;

        // Shortest (Minimum) path can be achieved using BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        distance[0] = 0;

        while(!queue.isEmpty()) {
            int curr = queue.remove();

            // If last node found
            if(curr == n - 1) return distance[curr];

            for(int i = 1; i <= 6; i++) {
                if(curr + i < n) {
                    int neighbor = moves.get(curr + i) == -1 ? curr + i : moves.get(curr + i);

                    // If last node found
                    if(neighbor == n - 1) return distance[curr] + 1;

                    // If node is not traversed
                    if(distance[neighbor] == -1) {
                        distance[neighbor] = distance[curr] + 1;
                        queue.add(neighbor);
                    }
                }
            }
        }

        return -1;
    }
}
