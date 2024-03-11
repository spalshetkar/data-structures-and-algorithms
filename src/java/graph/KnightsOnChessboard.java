package graph;

import java.util.*;

public class KnightsOnChessboard {
    public Integer find_minimum_number_of_moves(Integer rows, Integer cols, Integer start_row, Integer start_col, Integer end_row, Integer end_col) {
        // Same use case as visited array to check if node is already traversed or not and to avoid infinite loop
        int[][] distance = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) distance[i][j] = -1;
        }

        return bfs(rows, cols, start_row, start_col, end_row, end_col, distance);
    }

    private Integer bfs(int rows, int cols, int start_row, int start_col, int end_row, int end_col, int[][] distance) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start_row, start_col});
        distance[start_row][start_col] = 0;

        while(!queue.isEmpty()) {
            int[] node = queue.remove();

            List<List<Integer>> neighbors = helper(rows, cols, node[0], node[1], distance, node[0], node[1]);
            for (List<Integer> neighbor : neighbors) {
                int nRow = neighbor.get(0);
                int nCol = neighbor.get(1);

                // Target found
                if (nRow == end_row && nCol == end_col) return distance[node[0]][node[1]] + 1;

                // Unvisited node found
                if (distance[nRow][nCol] == -1) {
                    distance[nRow][nCol] = distance[node[0]][node[1]] + 1;

                    queue.add(new int[]{nRow, nCol});
                }
            }
        }

        return -1;
    }

    private List<List<Integer>> helper(int rows, int cols, int curr_row, int curr_col, int[][] distance, int row, int col) {
        // Directions to traverse all neighbors of the node
        int[][] directions = new int[][]{{2, 1}, {2, -1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {1, -2}, {-1, -2}};

        List<List<Integer>> result = new ArrayList<>();

        for(int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < rows && c >= 0 && c < cols && distance[r][c] == -1) result.add(Arrays.asList(r, c));
        }

        return result;
    }
}
