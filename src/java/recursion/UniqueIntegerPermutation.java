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
import java.util.List;

public class UniqueIntegerPermutation {
    public List<List<Integer>> get_permutations(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();

        // Root case
        helper(arr, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(List<Integer> arr, int index, List<Integer> slate, List<List<Integer>> result) {
        // Base case
        if(index == arr.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // Recursive case
        for(int i = index; i < arr.size(); i++) {
            int temp = arr.get(i);
            arr.set(i, arr.get(index));
            arr.set(index, temp);

            slate.add(temp);
            helper(arr, index+1, slate, result);
            slate.remove(slate.size() - 1);

            temp = arr.get(i);
            arr.set(i, arr.get(index));
            arr.set(index, temp);
        }
    }
}

/*
Time Complexity: O(n * n!)
Space Complexity: O(n * n!)
 */