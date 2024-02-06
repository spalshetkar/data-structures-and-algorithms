package sortingAndSearching;

/*
Problem:
Given an array of integers, find the k-th largest number in it.

Example:
{
"numbers": [5, 1, 10, 3, 2],
"k": 2
}
5

{
"numbers": [4, 1, 2, 2, 3],
"k": 4
}
2

Clarifying questions:
- Should duplicates be considered in this?
- Can k be more than the number of elements in the list?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInArray {
    public Integer kth_largest_in_an_array(List<Integer> numbers, Integer k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (Integer i : numbers)
            pq.offer(i);

        List<Integer> result = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            result.add(pq.peek());
            pq.poll();
        }

        return result.get(k - 1);
    }
}

/*
Time Complexity: O(n log k)
Space Complexity: O(k)
 */