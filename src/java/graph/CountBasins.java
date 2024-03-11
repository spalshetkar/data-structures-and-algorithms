package graph;

import java.util.*;

public class CountBasins {
    List<Integer> find_basins(List<List<Integer>> matrix) {
        int rowCount = matrix.size();
        int colCount = matrix.get(0).size();

        // Same as visited array - to store the basin number, to check if node is visited and to avoid infinite loop
        int[][] basin = new int[rowCount][colCount];
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) basin[i][j] = -1;
        }

        // To keep track of the basin number
        int basinNumber = 0;

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                // This dfs function will traverse all nodes and find the lowest sink for that node directly or indirectly (recursively)
                if(dfs(matrix, basin, i, j, basinNumber) == basinNumber) basinNumber++;
            }
        }

        List<Integer> result = new ArrayList<>();

        // This is to get all the unique basin numbers that we stored in basin array and add their total count to result
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) map.put(basin[i][j], map.getOrDefault(basin[i][j], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) result.add(entry.getValue());

        // For non decreasing order
        Collections.sort(result);
        return result;
    }

    private int dfs(List<List<Integer>> matrix, int[][] basin, int row, int column, int basinNumber) {
        // If unvisited node
        if(basin[row][column] == -1) {
            int minRow = row;
            int minCol = column;

            // Traverse up
            if(row > 0 && matrix.get(row - 1).get(column) < matrix.get(minRow).get(minCol)) {
                minRow = row - 1;
                minCol = column;
            }

            // Traverse down
            if(row < matrix.size() - 1 && matrix.get(row + 1).get(column) < matrix.get(minRow).get(minCol)) {
                minRow = row + 1;
                minCol = column;
            }

            // Traverse left
            if(column > 0 && matrix.get(row).get(column - 1) < matrix.get(minRow).get(minCol)) {
                minRow = row;
                minCol = column - 1;
            }

            // Traverse right
            if(column < matrix.get(row).size() - 1 && matrix.get(row).get(column + 1) < matrix.get(minRow).get(minCol)) {
                minRow = row;
                minCol = column + 1;
            }

            // If minimum row and column is the original row and column then return the basinNumber else recrusively get the sink's basin number
            if(minRow == row && minCol == column) basin[row][column] = basinNumber;
            else basin[row][column] = dfs(matrix, basin, minRow, minCol, basinNumber);
        }

        return basin[row][column];
    }
}
