package recursion;

/*
Problem:

Example:

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:
- Let's assume that we have the logic written for checking conflicts, how will I solve the problem then? Ans: That conflict checking can be a backtracking case
- How to check if diagonals don't have a queen already? Ans: row difference from current row to last row at that point - column difference from current column to last column at that point

Related questions:

Number of times attempted: 1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblem {
    public List<List<String>> find_all_arrangements(Integer n) {
        List<List<String>> result = new ArrayList<>();

        int[] columnSlate = new int[n];

        for(int i = 0; i < n; i++) columnSlate[i] = i;

        helper(n, 0, columnSlate, result);

        return result;
    }

    private void helper(int n, int index, int[] columnSlate, List<List<String>> result) {
        // Backtracking Case
        if(index > 0 && hasConflict(columnSlate, index - 1)) return;

        // Base Case
        if(index == n) {
            result.add(createBoard(n, columnSlate));
            return;
        }

        // Recursive Case
        for(int i = index; i < n; i++) {
            swap(columnSlate, index, i);
            helper(n, index + 1, columnSlate, result);
            swap(columnSlate, index, i);
        }

    }

    private boolean hasConflict(int[] columnSlate, int prevIndex) {
        for(int row = 0; row < prevIndex; row++) {
            if(columnSlate[prevIndex] == columnSlate[row]) return true; // checking if any queen is on the same column

            int rowDiff = Math.abs(prevIndex - row);
            int columnDiff = Math.abs(columnSlate[prevIndex] - columnSlate[row]);
            if(rowDiff == columnDiff) return true; // checking if any queen is on the same diagonal
        }

        return false;
    }

    private List<String> createBoard(int n, int[] columnSlate) {
        List<String> board = new ArrayList<>();

        // Adding elements in the board is done in this way to avoid O(n^2) time complexity
        char[] temp = new char[n];
        Arrays.fill(temp, '-');

        for(int i = 0; i < n; i++) {
            temp[columnSlate[i]] = 'q';
            board.add(new String(temp));
            temp[columnSlate[i]] = '-';
        }

        return board;
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

/*
Time Complexity:
Space Complexity:
 */