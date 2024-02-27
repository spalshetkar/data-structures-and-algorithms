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

public class AllExpressionsThatEqualToTarget {
    List<String> generate_all_expressions(String s, Long target) {
        List<String> result = new ArrayList<>();
        int[] input = new int[s.length()];
        for(int i = 0; i < s.length(); i++) input[i] = (int) (s.charAt(i) - '0');

        helper(input, 1, target, new StringBuilder("" + input[0]), 0, 1, input[0], result);

        return result;
    }

    private void helper(int[] input, int index, Long target, StringBuilder slate, long sum , long product, long currNumber, List<String> result) {
        // Base Case
        if(index == input.length) {
            // Inner Backtracking Case
            if(sum + (product * currNumber) == target) result.add(new String(slate));
            return;
        }

        // Recursive Case
        // Concat
        slate.append(input[index]);
        helper(input, index + 1, target, slate, sum, product, (currNumber * 10) + input[index], result);
        slate.deleteCharAt(slate.length() - 1);

        // Addition
        slate.append("" + '+');
        slate.append(input[index]);
        helper(input, index + 1, target, slate, sum + product * currNumber, 1, input[index], result);
        slate.deleteCharAt(slate.length() - 1);
        slate.deleteCharAt(slate.length() - 1);

        // Multiplication
        slate.append("" + '*');
        slate.append(input[index]);
        helper(input, index + 1, target, slate, sum, product * currNumber, input[index], result);
        slate.deleteCharAt(slate.length() - 1);
        slate.deleteCharAt(slate.length() - 1);

        return;
    }
}

/*
Time Complexity:
Space Complexity:
 */