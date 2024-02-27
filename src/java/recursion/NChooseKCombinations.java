package recursion;

/*
Problem:
Given two integers n and k, find all the possible unique combinations of k numbers in range 1 to n.

Example:
{
"n": 5,
"k": 2
}

[
[1, 2],
[1, 3],
[1, 4],
[1, 5],
[2, 3],
[2, 4],
[2, 5],
[3, 4],
[3, 5],
[4, 5]
]

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.ArrayList;
import java.util.List;

public class NChooseKCombinations {

    public List<List<Integer>> find_combinations(Integer n, Integer k) {
        List<List<Integer>> result = new ArrayList<>();

        helper(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private static void helper(int index, int n, int k, List<Integer> slate, List<List<Integer>> result) {
        // Backtracking Case
        if(slate.size() == k) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // Base Case
        if(index > n) return;

        // Recursion Case
        // Exclude
        helper(index + 1, n, k, slate, result);

        // Include
        slate.add(index);
        helper(index + 1, n, k, slate, result);
        slate.remove(slate.size() - 1);

        return;
    }
}
