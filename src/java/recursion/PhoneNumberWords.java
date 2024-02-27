package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class PhoneNumberWords {
    public List<String> get_words_from_phone_number(String phoneNumber) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        map.put(0, new StringBuilder());
        map.put(1, new StringBuilder());
        char ch = 'a';
        for(int i = 2; i <= 9; i++) {
            int counter = (i == 7 || i == 9) ? 4 : 3;
            for(int j = 0; j < counter; j++) {
                map.put(i, map.getOrDefault(i, new StringBuilder()).append(ch));
                ch++;
            }
        }

        List<String> result = new ArrayList<>();

        // Root Case
        helper(phoneNumber, map, 0, new StringBuilder(), result);

        return result;
    }

    private void helper(String phoneNumber, Map<Integer, StringBuilder> map, int index, StringBuilder slate, List<String> result) {
        // Backtracking Case

        // Base Case
        if(index == phoneNumber.length()) {
            result.add(new String(slate));
            return;
        }

        // Recursive Case
        StringBuilder temp = map.get((int)phoneNumber.charAt(index));
        for(int i = 0; i < temp.length(); i++) {
            slate.append(temp.charAt(i));
            helper(phoneNumber, map, index + 1, slate, result);
            slate.deleteCharAt(slate.length() - 1);
        }

        return;
    }
}

/*
Time Complexity: O(4^n)
Space Complexity: O(2^n)
 */