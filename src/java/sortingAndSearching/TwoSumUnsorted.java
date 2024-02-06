package sortingAndSearching;

/*
Problem:
Given an array and a target number, find the indices of the two values from the array that sum up to the given target number.

Example:
{
"numbers": [5, 3, 10, 45, 1],
"target": 6
}
[0, 4]

Clarifying questions:
- Will there be duplicates?
- Will there be negative numbers?

Test cases:
8 2 4 9 3 6

Brute force approach:
Run with 2 for loops making time complexity O(n^2)

Optimized approach:
Use hashing

Intuition:
By using HashMap, we will check if the current number - target is already present in map
The check will take O(1) time and will execute n times.

Related questions:

Number of times attempted: 1
 */

import java.util.*;

public class TwoSumUnsorted {
    List<Integer> two_sum(List<Integer> numbers, Integer target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < numbers.size(); i++) {
            int key = target - numbers.get(i);

            if(map.containsKey(key)) return Arrays.asList(map.get(key), i); // Takes O(1) time

            map.put(numbers.get(i), i);
        }

        return Arrays.asList(-1, -1);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
 */
