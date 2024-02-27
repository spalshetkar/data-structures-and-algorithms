package recursion;

/*
Problem:

Example:

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:
- What are the options here? Ans: Either concat to the slate or create a new partition '|'
- How to check palindrome? Ans: Check is the last string is palindrome each time

Related questions:

Number of times attempted: 1
 */

import java.util.ArrayList;
import java.util.List;

public class AllPalindromeOfString {
    List<String> generate_palindromic_decompositions(String s) {
        if(s.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        // Root Case
        helper(s, 1, new StringBuilder(s.charAt(0)), s.charAt(0) + "", result);

        return result;
    }

    private void helper(String s, int index, StringBuilder slate, String lastString, List<String> result) {
        // Base Case
        if(index == s.length()) {
            if(isPalindrome(lastString)) result.add(new String(slate));

            return;
        }

        // Recursive Case
        // Concat
        slate.append(s.charAt(index));
        helper(s, index + 1, slate, lastString + s.charAt(index), result);
        slate.deleteCharAt(slate.length() - 1);

        // Partition
        // Inner Backtracking Case
        if(!isPalindrome(lastString)) return;

        slate.append('|');
        slate.append(s.charAt(index));
        helper(s, index + 1, slate, s.charAt(index) + "", result);
        slate.deleteCharAt(slate.length() - 1);
        slate.deleteCharAt(slate.length() - 1);

        return;
    }

    private boolean isPalindrome(String lastString) {
        int start = 0;
        int end = lastString.length() - 1;

        while(start <= end) {
            if(lastString.charAt(start) != lastString.charAt(end)) return false;

            start++;
            end--;
        }

        return true;
    }
}
