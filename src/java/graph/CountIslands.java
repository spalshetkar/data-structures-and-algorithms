package graph;

import java.util.*;

public class CountIslands {
    public Integer count_islands(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[][] visited = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) visited[i][j] = -1;
        }

        // Check number of components
        int components = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                // Edge node found
                if(visited[i][j] == -1) {
                    if(matrix.get(i).get(j) == 1) {
                        // Traverse all neighbors equal to 1
                        bfs(matrix, visited, i, j);
                        // dfs(matrix, visited, i, j);

                        components++;
                    }
                }
            }
        }

        return components;
    }

    private void bfs(List<List<Integer>> matrix, int[][] visited, int row, int column) {
        visited[row][column] = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row, column});

        while(!queue.isEmpty()) {
            int[] node = queue.remove();

            List<List<Integer>> neighbors = helper(matrix, visited, node[0], node[1]);
            for(int i = 0; i < neighbors.size(); i++) {
                int nRow = neighbors.get(i).get(0);
                int nCol = neighbors.get(i).get(1);

                visited[nRow][nCol] = 1;

                queue.add(new int[]{nRow, nCol});
            }
        }

        return;
    }

    private List<List<Integer>> helper(List<List<Integer>> matrix, int[][] visited, int row, int col) {
        // Directions to traverse all neighbors of the node
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        List<List<Integer>> result = new ArrayList<>();

        for(int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < matrix.size() && c >= 0 && c < matrix.get(0).size() && matrix.get(r).get(c) == 1 && visited[r][c] == -1) result.add(Arrays.asList(r, c));
        }

        return result;
    }

    private void dfs(List<List<Integer>> matrix, int[][] visited, int row, int column) {
        if((row >= matrix.size() || row < 0) || (column >= matrix.get(row).size() || column < 0) || (matrix.get(row).get(column) == 0) || (visited[row][column] == 1)) return;

        visited[row][column] = 1;

        // Cover all 4 neighbors
        dfs(matrix, visited, row + 1, column);
        dfs(matrix, visited, row - 1, column);
        dfs(matrix, visited, row, column + 1);
        dfs(matrix, visited, row, column - 1);

        // Cover all diagonal neighbors
        dfs(matrix, visited, row - 1, column - 1);
        dfs(matrix, visited, row - 1, column + 1);
        dfs(matrix, visited, row + 1, column - 1);
        dfs(matrix, visited, row + 1, column + 1);

        return;
    }
}
