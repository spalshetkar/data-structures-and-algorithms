package recursion;

/*
Problem:
Given an array of numbers with possible duplicates, return all of its permutations in any order.

Example:
{
"arr": [1, 2, 2]
}

[
[1, 2, 2],
[2, 1, 2],
[2, 2, 1]
]

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.*;

public class DuplicateIntegerPermutation {
    List<List<Integer>> get_permutations(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();

        if(arr != null) Collections.sort(arr);
        helper(arr, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(List<Integer> arr, int index, List<Integer> slate, List<List<Integer>> result) {
        // Base case
        if(index == arr.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }

        Set<Integer> set = new HashSet<>();

        // Recursive case
        for(int i = index; i < arr.size(); i++) {
            if(set.contains(arr.get(i))) continue; // checking for duplicates

            int temp = arr.get(i);
            arr.set(i, arr.get(index));
            arr.set(index, temp);

            slate.add(temp);
            helper(arr, index+1, slate, result);
            slate.remove(slate.size() - 1);

            temp = arr.get(i);
            arr.set(i, arr.get(index));
            arr.set(index, temp);
            set.add(arr.get(i));

            set.add(arr.get(i));
        }

        return;
    }
}

/*
Time Complexity:
Space Complexity:
 */