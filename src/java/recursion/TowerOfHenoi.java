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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfHenoi {
    List<List<Integer>> tower_of_hanoi(Integer n) {
        List<List<Integer>> result = new ArrayList<>();

        helper(n, 1, 2, 3, result);

        return result;
    }

    private void helper(int n, int src, int dest, int aux, List<List<Integer>> result) {
        // Base Case
        if(n == 1) {
            result.add(Arrays.asList(src, dest));
            return;
        }

        // Recursive Case
        // Put n - 1 disks into aux so that only 1 disk remains in src
        helper(n-1, src, aux, dest, result);

        // Put remaining 1 disk in src to dest
        helper(1, src, dest, aux, result);

        // Put n - 1 disks from aux into dest to complete the problem
        helper(n-1, aux, dest, src, result);

        return;
    }
}

/*
Time Complexity:
Space Complexity:
 */