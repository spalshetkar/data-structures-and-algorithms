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
Splits array into 2 half -> delegates sorting the 2 halves to the sub manager nodes -> once the 2 sorted sub arrays are returned,
sorts the 2 arrays and merges them into 1 array

Uses divide and conquer strategy

Related questions:

Number of times attempted: 1
 */

public class MergeSort {

    public int[] sort(int[] input) {

        return helper(input, 0, input.length - 1);
    }

    private int[] helper(int[] input, int start, int end) {

        // Leaf Node
        if(start == end) return input;

        // Auxiliary Node
        int mid = (start + end) / 2;

        int[] leftArr = helper(input, start, mid);
        int[] rightArr = helper(input, mid+1, end);

        int[] auxArr = new int[input.length];

        int i = start, j = mid+1;
        int k = 0;

        while(i <= mid && j <= end) {
            if(leftArr[i] < rightArr[j]) {
                auxArr[k] = leftArr[i];
                i++;
            }
            else {
                auxArr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        while(i <= mid) {
            auxArr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j <= end) {
            auxArr[k] = rightArr[j];
            j++;
            k++;
        }

        return auxArr;
    }
}

/*
Time Complexity: O(n log n)
Space Complexity: O(n)
 */