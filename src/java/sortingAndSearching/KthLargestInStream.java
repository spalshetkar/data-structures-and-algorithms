package sortingAndSearching;

/*
Problem:
Given an initial list along with another list of numbers to be appended with the initial list and an integer k, return an array consisting of the k-th largest element after adding each element from the first list to the second list.

Example:
{
"k": 2,
"initial_stream": [4, 6],
"append_stream": [5, 2, 20]
}
[5, 5, 6]
Append	Stream	            Sorted Stream	    2nd largest
5	    [4, 6, 5]	        [4, 5, 6]	        5
2	    [4, 6, 5, 2]	    [2, 4, 5, 6]	    5
20	    [4, 6, 5, 2, 20]	[2, 4, 5, 6, 20]	6

Clarifying questions:
- Can k be more than the initial stream length?
- Can append stream be empty?

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

public class KthLargestInStream {
    public List<Integer> kth_largest(Integer k, List<Integer> initial_stream, List<Integer> append_stream) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        List<Integer> result = new ArrayList<>();

        for(Integer i : initial_stream) {
            pq.offer(i);

            if(pq.size() > k)
                pq.poll();
        }

        for(int i = 0; i < append_stream.size(); i++) {

            pq.offer(append_stream.get(i));

            if(pq.size() > k)
                pq.poll();

            result.add(pq.peek());
        }

        return result;
    }
}

/*
Time Complexity: O(n + m)
Space Complexity: O(k)
 */