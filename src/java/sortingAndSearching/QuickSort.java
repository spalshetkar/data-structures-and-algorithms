package sortingAndSearching;

/*
Clarifying questions:
- Will there be duplicates?
- Will there be negative numbers?

Test cases:
8 2 4 9 3 6

Brute force approach:
-

Optimized approach:
-

Intuition:
Splits the array into 2 sub arrays based on pivot element.
Left sub array would have numbers less than pivot and right sub array would have numbers more than pivot.

In Hoare's method smaller index points to start+1 index and bigger index points to end index.

Uses divide and conquer strategy

Related questions:

Number of times attempted: 1
 */

public class QuickSort {

    public int[] sort(int[] input) {
        helper(input, 0, input.length - 1);
        return input;
    }

    private void helper(int[] input, int start, int end) {

        // Leaf Node
        if(start == end) return;

        // Arbitrary Node
        int small = start + 1;
        int big = end;

        while(small <= big) {
            if(input[small] < input[start])
                small++;
            else if(input[big] > input[start])
                big--;
            else {
                swap(small, big, input);
                small++;
                big--;
            }
        }
        swap(start, big, input);

        helper(input, start, big - 1);
        helper(input, big + 1, end);
    }

    private void swap(int firstPos, int secondPos, int[] input) {
        int temp = input[firstPos];
        input[firstPos] = input[secondPos];
        input[secondPos] = temp;
    }
}

/*
Time Complexity: O(n ^ 2) (Worst case) O(n log n) (Average case)
Space Complexity: O(n)
 */