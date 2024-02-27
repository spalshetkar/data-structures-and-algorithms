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

public class AllSubsets {
    public List<String> generate_all_subsets(String s) {
        List<String> result = new ArrayList<>();

        // Root Case
        helper(s, 0, new StringBuilder(), result);

        return result;
    }

    private void helper(String s, int index, StringBuilder slate, List<String> result) {
        // Base Case
        if(index == s.length()) {
            result.add(new String(slate));
            return;
        }

        // Recursive Case
        // Exclude
        helper(s, index + 1, slate, result);

        // Include
        slate.append(s.charAt(index));
        helper(s, index + 1, slate, result);
        slate.deleteCharAt(slate.length() - 1);

        return;
    }
}

/*
Time Complexity:
Space Complexity:
 */