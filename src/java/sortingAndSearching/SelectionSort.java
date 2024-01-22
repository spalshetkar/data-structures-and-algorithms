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
Selects the lowest number from the array and puts it at the start at every pass

Related questions:

Number of times attempted: 1
 */

public class SelectionSort {
    public int[] sort(int[] input) {

        int n = input.length;
        for(int i = 0; i <= n-1; i++) {
            int minVal = input[i];
            int minPos = i;

            for(int j = i+1; j <= n-1; j++) {
                if(input[j] < minVal) {
                    minVal = input[j];
                    minPos = j;
                }
            }

            swap(i, minPos, input);
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