package recursion;

/*
Problem:
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. Return the output in any order.

Example:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

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

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        // Root Case
        List<String> result = new ArrayList<>();
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
        if(Character.isDigit(s.charAt(index))) {
            slate.append(s.charAt(index));
            helper(s, index+1, slate, result);
            slate.deleteCharAt(slate.length() - 1);
        }
        else {
            slate.append(Character.toUpperCase(s.charAt(index)));
            helper(s, index+1, slate, result);
            slate.deleteCharAt(slate.length() - 1);

            slate.append(Character.toLowerCase(s.charAt(index)));
            helper(s, index+1, slate, result);
            slate.deleteCharAt(slate.length() - 1);
        }
    }
}

/*
Time Complexity:
Space Complexity:
 */