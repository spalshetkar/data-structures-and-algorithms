package recursion;

/*
Problem:
Given a string that might contain duplicate characters, find all the possible distinct subsets of that string.

Example:
{
"s": "aab"
}
Output:
["", "a", "aa", "aab", "ab", "b"]

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

public class SubsetsWithDuplicateCharacters {
    public List<String> get_distinct_subsets(String s) {
        List<String> result = new ArrayList<>();
        char[] input = s.toCharArray();
        Arrays.sort(input);

        // Root Case
        helper(input, 0, new StringBuilder(), result);

        return result;
    }
    private void helper(char[] input, int index, StringBuilder slate, List<String> result) {
        // Base Case
        if(index == input.length) {
            result.add(new String(slate));
            return;
        }

        // Recursive Case
        int end = index + 1;
        while(end <= input.length - 1 && input[end] == input[index]) end++;

        // Exclusion
        helper(input, end, slate, result);

        // Inclusion
        int count = end - index;
        StringBuilder temp = new StringBuilder();

        while(count != 0) {
            temp.append(input[index]);

            slate.append(temp);
            helper(input, end, slate, result);
            slate.deleteCharAt(slate.length() - temp.length());

            count--;
        }

        return;
    }

}