package sortingAndSearching;

/*
Problem:
Given a list of characters, sort it in the non-decreasing order based on ASCII values of characters.

Example:
{
"arr": ["a", "s", "d", "f", "g", "*", "&", "!", "z", "y"]
}
["!", "&", "*", "a", "d", "f", "g", "s", "y", "z"]

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:
- Counting frequency of each ASCII value

Intuition:
- As there are a finite number of elements to sort from, counting frequency instead of using quick or merge sort is better

Related questions:

Number of times attempted: 1
 */

import java.util.List;

public class SortCharacters {
    public List<Character> sort_array(List<Character> arr) {
        int[] temp = new int[128];

        for(char c : arr) {
            temp[c]++;
        }

        int k = 0;
        for(int i  = 0; i < 128; i++) {
            for(int j = 0; j < temp[i]; j++) {
                arr.set(k, (char)i);
                k++;
            }
        }

        return arr;
    }
}

/*
Time Complexity; O(n)
Space Complexity: O(1)
 */