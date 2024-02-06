package sortingAndSearching;

/*
Problem:
Given an integer array and a number k, find the k most frequent elements in the array.

Example:
{
"arr": [1, 2, 3, 2, 4, 3, 1],
"k": 2
}
[3, 1]

Clarifying questions:
- Can k be more than the number of unique elements in the list?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.*;

public class MostFrequentKElements {
    public List<Integer> find_top_k_frequent_elements(List<Integer> arr, Integer k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));

        for(int i = 0; i < arr.size(); i++) map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);

        for(Map.Entry<Integer, Integer> key : map.entrySet()) {
            pq.offer(key.getKey());

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            result.add(pq.peek());
            pq.poll();
        }
        return result;
    }
}

/*
Time Complexity: O(n log k)
Space Complexity: O(n)
 */