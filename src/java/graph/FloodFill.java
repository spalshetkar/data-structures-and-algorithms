package graph;

import java.util.*;

public class FloodFill {
    List<List<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, List<List<Integer>> image) {
        int rows = image.size();
        int columns = image.get(0).size();

        // Visited array to keep track of visited nodes and avoid infinite loop
        int[][] visited = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) visited[i][j] = -1;
        }

        int oldColor = image.get(pixel_row).get(pixel_column);

        // Traverse all neighbors equal to
        bfs(image, visited, oldColor, new_color, pixel_row, pixel_column);
        // dfs(image, visited, oldColor, newColor, pixel_row, pixel_column);

        return image;
    }

    private void bfs(List<List<Integer>> image, int[][] visited, int oldColor, int newColor, int row, int column) {
        visited[row][column] = 1;
        List<Integer> temp = image.get(row);
        temp.set(column, newColor);
        image.set(row, temp);

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row, column});

        while(!queue.isEmpty()) {
            int[] node = queue.remove();

            List<List<Integer>> neighbors = helper(image, visited, oldColor, newColor, node[0], node[1]);
            for(int i = 0; i < neighbors.size(); i++) {
                int nRow = neighbors.get(i).get(0);
                int nCol = neighbors.get(i).get(1);

                visited[nRow][nCol] = 1;
                List<Integer> temp = image.get(nRow);
                temp.set(nCol, newColor);
                image.set(nRow, temp);

                queue.add(new int[]{nRow, nCol});
            }
        }

        return;
    }

    private List<List<Integer>> helper(List<List<Integer>> image, int[][] visited, int oldColor, int newColor, int row, int col) {
        // Directions to traverse all neighbors of the node
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        List<List<Integer>> result = new ArrayList<>();

        for(int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < image.size() && c >= 0 && c < image.get(0).size() && image.get(r).get(c) == oldColor && visited[r][c] == -1) result.add(Arrays.asList(r, c));
        }

        return result;
    }

    private void dfs(List<List<Integer>> image, int[][] visited, int oldColor, int newColor, int row, int column) {
        if((row >= image.size() || row < 0) || (column >= image.get(row).size() || column < 0) || (image.get(row).get(column) != oldColor) || (visited[row][column] == 1)) return;

        visited[row][column] = 1;
        List<Integer> temp = image.get(row);
        temp.set(column, newColor);
        image.set(row, temp);

        // Cover all 4 neighbors
        dfs(image, visited, oldColor, newColor, row + 1, column);
        dfs(image, visited, oldColor, newColor, row - 1, column);
        dfs(image, visited, oldColor, newColor, row, column + 1);
        dfs(image, visited, oldColor, newColor, row, column - 1);

        return;
    }
}
