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
Inserts the selected element in the left sorted sub array at the appropriate position.

This left sorted sub array is sorted bu a "sub lazy manager" -
What this means is that some arbitrary manager's job is to only put that element into the left sorted sub array,
but has delegated the task to sort the left sub array to some sub lazy manager. (Manager meaning one iteration)

Uses decrease and conquer strategy

Related questions:

Number of times attempted: 1
 */

public class InsertionSort {

    public int[] sort(int[] input) {

        int n = input.length;
        for(int i = 0; i <= n-1; i++) {

            int temp = input[i];
            int j = i-1;
            while(j >= 0 && input[j] > temp) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = temp;
        }

        return input;
    }
}

/*
Time Complexity: O(n^2)
Space Complexity: O(1)
 */