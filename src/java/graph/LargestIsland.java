package graph;

import java.util.*;

public class LargestIsland {
    Integer max_island_size(List<List<Integer>> grid) {
        int rows = grid.size();
        int columns = grid.get(0).size();

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[][] visited = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) visited[i][j] = -1;
        }

        // Check number of components
        int components = 0;

        // For calculating length of island and largest island
        int sum = 0, maxSum = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                // Edge node found
                if(visited[i][j] == -1) {
                    if(grid.get(i).get(j) == 1) {
                        // Traverse all neighbors equal to 1
                        sum = bfs(grid, visited, i, j);
                        // int[] temp = new int[]{0};
                        // dfs(grid, visited, i, j, temp);
                        // sum = temp[0];

                        components++;
                    }
                }

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    private int bfs(List<List<Integer>> grid, int[][] visited, int row, int column) {
        int sum = 1;

        visited[row][column] = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row, column});

        while(!queue.isEmpty()) {
            int[] node = queue.remove();

            List<List<Integer>> neighbors = helper(grid, visited, node[0], node[1]);
            for(int i = 0; i < neighbors.size(); i++) {
                int nRow = neighbors.get(i).get(0);
                int nCol = neighbors.get(i).get(1);

                visited[nRow][nCol] = 1;

                queue.add(new int[]{nRow, nCol});

                sum++;
            }
        }

        return sum;
    }

    private List<List<Integer>> helper(List<List<Integer>> grid, int[][] visited, int row, int col) {
        // Directions to traverse all neighbors of the node
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        List<List<Integer>> result = new ArrayList<>();

        for(int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < grid.size() && c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) == 1 && visited[r][c] == -1) result.add(Arrays.asList(r, c));
        }

        return result;
    }

    private void dfs(List<List<Integer>> grid, int[][] visited, int row, int column, int[] sum) {
        if((row >= grid.size() || row < 0) || (column >= grid.get(row).size() || column < 0) || (grid.get(row).get(column) == 0) || (visited[row][column] == 1)) return;

        visited[row][column] = 1;
        sum[0]++;

        // Cover all 4 neighbors
        dfs(grid, visited, row + 1, column, sum);
        dfs(grid, visited, row - 1, column, sum);
        dfs(grid, visited, row, column + 1, sum);
        dfs(grid, visited, row, column - 1, sum);

        return;
    }
}
