package recursion;

/*
Problem:
Given an integer array, generate all the unique combinations of the array numbers that sum up to a given target value.

Example:
{
"arr": [1, 1, 1, 2, 3],
"target": 3
}
Output:
[
[3],
[1, 2],
[1, 1, 1]
]

Clarifying questions:
- Does order of the elements matter?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.*;

public class AllCombinationsEqualToTarget {
    public List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
        Collections.sort(arr);
        Set<ArrayList<Integer>> result = new HashSet<>();

        helper(arr, target, 0, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    private static void helper(List<Integer> arr, int target, int index, List<Integer> slate, Set<ArrayList<Integer>> result) {
        // Backtracking Case
        if(target == 0) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // Base Case
        if(index == arr.size() || target < 0) return;

        // Recursion Case
        int end = index + 1;
        while(end < arr.size() - 1 && arr.get(end) == arr.get(index)) end++;

        // Exclude
        helper(arr, target, end, slate, result);

        // Include
        int sum = 0;
        List<Integer> temp = new ArrayList<>();

        for(int count = 0; count < end - index; count++) {
            int current = arr.get(index + count);

            sum += current;
            temp.add(current);

            slate.addAll(temp);
            helper(arr, target - sum, end, slate, result);
            for(int i = 0; i < temp.size(); i++) slate.remove(slate.size() - 1);
        }

        return;
    }
}

/*
Time Complexity:
Space Complexity:
 */