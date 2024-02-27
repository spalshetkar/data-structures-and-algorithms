package recursion;

/*
Problem:

Example:

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:
- What will the number of BST for each element from 1 to n?
- What  if there are no elements on the left or right of the BST? How many BSTs can be created in that case?
- Number of BSTs for any arbitrary element 'i' will be BSTs of left subtree * BSTs of right subtree

Related questions:

Number of times attempted: 1
 */

public class BinarySearchTreesWithNNodes {
    public Long how_many_BSTs(int n) {
        // Root Case
        return helper(n);
    }

    private static Long helper(int n) {
        // Base Case
        if(n == 0 || n == 1) return 1L;

        // Recursive Case
        Long sum = 0L;

        for(int i = 1; i <= n; i++) {
            sum += helper(i - 1) * helper(n - i);
        }

        return sum;
    }
}
