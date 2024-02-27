package recursion;

/*
Problem:

Example:

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.List;

public class SudokuProblem {
    List<List<Integer>> solve_sudoku_puzzle(List<List<Integer>> board) {
        helper(board);

        return board;
    }

    private boolean helper(List<List<Integer>> board) {
        // Root Case: Find the next unfilled cell on the board
        boolean foundBlankCell = false;
        int row = 0;
        int column = 0;

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board.get(i).get(j) == 0) {
                    row = i;
                    column = j;
                    foundBlankCell = true;
                    break;
                }
            }
            if(foundBlankCell) break;
        }

        // Base Case: If all cells have been filled then a solution is found
        if(!foundBlankCell) return true;

        // Recursive Case: If there is a current unfilled cell, then check all possible numbers for that cell
        for(int num = 1; num <= 9; num++) {
            if(!hasConflict(board, row, column, num)) {
                board.get(row).set(column, num);
                if(helper(board)) return true;
                board.get(row).set(column, 0);
            }
        }

        return false;
    }

    private boolean hasConflict(List<List<Integer>> board, int row, int column, int num) {
        // Check conflict in same row
        for(int i = 0; i < 9; i++) {
            if(board.get(row).get(i) == num) return true;
        }

        // Check conflict in same column
        for(int i = 0; i < 9; i++) {
            if(board.get(i).get(column) == num) return true;
        }

        // Check conflict in current grid
        int rowStart = row - row % 3;
        int columnStart = column - column % 3;
        for(int i = rowStart; i < rowStart + 3; i++) {
            for(int j = columnStart; j < columnStart + 3; j++) {
                if(board.get(i).get(j) == num) return true;
            }
        }

        return false;
    }
}

/*
Time Complexity:
Space Complexity:
 */