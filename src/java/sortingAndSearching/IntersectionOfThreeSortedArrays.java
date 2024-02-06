package sortingAndSearching;

/*
Problem:
Given three arrays sorted in the ascending order, return their intersection sorted array in the ascending order.

Example:
{
"arr1": [2, 5, 10],
"arr2": [2, 3, 4, 10],
"arr3": [2, 4, 10]
}
[2, 10]

Clarifying questions:
- Should duplicates be added in result as well?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArrays {
    public List<Integer> find_intersection(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0; int j = 0; int k = 0;

        while(i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            int num1 = arr1.get(i);
            int num2 = arr2.get(j);
            int num3 = arr3.get(k);

            if(num1 == num2 && num2 == num3)
                result.add(num1);

            int min = Math.min(num1, num2);
            min = Math.min(min, num3);

            if(num1 == min) i++;
            if(num2 == min) j++;
            if(num3 == min) k++;
        }

        if(result.isEmpty())
            result.add(-1);
        return result;
    }
}

/*
Time Complexity: O(n + m + l)
Space Complexity: O(1)
 */