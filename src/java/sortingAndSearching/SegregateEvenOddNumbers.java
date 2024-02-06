package sortingAndSearching;

import java.util.List;

/*
Problem:
Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.

Example:
{
"numbers": [1, 2, 3, 4]
}
[4, 2, 3, 1]
following are also correct outputs: [4, 2, 1, 3], [2, 4, 1, 3], [2, 4, 3, 1]

Clarifying questions:
- Will there be only odd or only even numbers?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

public class SegregateEvenOddNumbers {
    List<Integer> segregate_evens_and_odds(List<Integer> numbers) {
        int even = 0;
        int odd = numbers.size() - 1;

        while(even <= odd) {
            if(numbers.get(odd) % 2 == 0) {
                int temp = numbers.get(even);
                numbers.set(even, numbers.get(odd));
                numbers.set(odd, temp);

                even++;
            }
            else odd--;
        }

        return numbers;
    }
}

/*
Time Complexity:
Space Complexity:
 */