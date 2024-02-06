package sortingAndSearching;

/*
Problem:
Given an array sorted in non-decreasing order and a target number, find the indices of the two values from the array that sum up to the given target number.

Example:
{
"numbers": [1, 2, 3, 5, 10],
"target": 7
}
[1, 3]

Clarifying questions:
- Will there be duplicates?
- Will there be negative numbers?

Test cases:
8 2 4 9 3 6

Brute force approach:
Double for loop to find sum.

Optimized approach:
Binary search

Intuition:
Since array is sorted we know that binary search will be the optimized solution to find the sum.

Related questions:

Number of times attempted: 1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumSorted {
    public List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {
        int start = 0;
        int end = numbers.size() - 1;
        int sum = 0;

        while(start < end) {
            sum = numbers.get(start) + numbers.get(end);

            if(sum < target) start++;
            else if (sum > target) end--;
            else {
                return Arrays.asList(start, end);
            }
        }

        return Arrays.asList(-1, -1);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
 */