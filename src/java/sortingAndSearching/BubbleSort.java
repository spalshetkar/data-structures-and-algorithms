package sortingAndSearching;

/*
Clarifying questions:
- Will there be duplicates?
- Will there be negative numbers?

Test cases:


Brute force approach:
-

Optimized approach:
-

Intuition:
Compares neighbouring element from right to left at every pass

Related questions:

Number of times attempted: 1
 */

public class BubbleSort {
    public int[] sort(int[] input) {

        int n = input.length;
        for(int i = 0; i <= n-1; i++) {
            for(int j = n-1; j >= i+1; j--) {
                if(input[j] < input[j-1])
                    swap(j, j-1, input);
            }
        }

        return input;
    }

    private void swap(int firstPos, int secondPos, int[] input) {
        int temp = input[firstPos];
        input[firstPos] = input[secondPos];
        input[secondPos] = temp;
    }
}

/*
Time Complexity: O(n^2)
Space Complexity: O(1)
 */