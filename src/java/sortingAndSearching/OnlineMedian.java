package sortingAndSearching;

/*
Problem:
Given a list of numbers, the task is to insert these numbers into a stream and find the median of the stream after each insertion. If the median is a non-integer, consider it’s floor value.

The median of a sorted array is defined as the middle element when the number of elements is odd and the mean of the middle two elements when the number of elements is even.

Example:
{
"stream": [3, 8, 5, 2]
}
[3, 5, 5, 4]
Iteration	Stream	        Sorted Stream	Median
1	        [3]	            [3]	            3
2	        [3, 8]	        [3, 8]	        (3 + 8) / 2 => 5
3	        [3, 8, 5]	    [3, 5, 8]	    5
4	        [3, 8, 5, 2]	[2, 3, 5, 8]	(3 + 5) / 2 => 4

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
import java.util.PriorityQueue;
import java.util.Queue;

public class OnlineMedian {
    static List<Integer> online_median(List<Integer> stream) {
        Queue<Integer> smaller = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<Integer> larger = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for(int num : stream) {
            // Balancing heaps to make sure.
            // - smaller half of input numbers are always in the max heap
            // - larger half of input numbers are always in the min heap
            smaller.add(num);
            larger.add(smaller.peek());
            smaller.poll();

            // Maintain size property.
            // 1. max_heap.size() = min_heap.size(), when number of elements is even
            // 2. max_heap.size() = min_heap.size() + 1, when number of elements is odd
            if (larger.size() > smaller.size()) {
                smaller.add(larger.peek());
                larger.poll();
            }

            // If number of elements in the stream is even.
            if (smaller.size() == larger.size())
                result.add((smaller.peek() + larger.peek()) / 2);

            // If number of elements in the stream is odd.
            else result.add(smaller.peek());
        }

        return result;
    }
}

/*
Time Complexity:
Space Complexity:
 */