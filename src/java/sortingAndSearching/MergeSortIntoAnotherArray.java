package sortingAndSearching;

/*
Problem:
First array has n positive numbers, and they are sorted in the non-descending order.

Second array has 2n numbers: first n are also positive and sorted in the same way but the last n are all zeroes.

Merge the first array into the second and return the latter. You should get 2n positive integers sorted in the non-descending order.

Example:
{
"first": [1, 3, 5],
"second": [2, 4, 6, 0, 0, 0]
}
[1, 2, 3, 4, 5, 6]

Clarifying questions:
- Would the number of zeros in second array match length of first array?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.List;

public class MergeSortIntoAnotherArray {
    List<Integer> merge_one_into_another(List<Integer> first, List<Integer> second) {
        int i = first.size() - 1;
        int j = first.size() - 1;
        int k = second.size() - 1;

        while(i >= 0 && j >= 0) {
            if(first.get(i) > second.get(j)) {
                second.set(k, first.get(i));
                k--;
                i--;
            }
            else {
                second.set(k, second.get(j));
                k--;
                j--;
            }
        }

        while(i >= 0) {
            second.set(k, first.get(i));
            k--;
            i--;
        }

        while(j >= 0) {
            second.set(k, second.get(j));
            k--;
            j--;
        }

        return second;
    }
}

/*
Time Complexity:
Space Complexity:
 */