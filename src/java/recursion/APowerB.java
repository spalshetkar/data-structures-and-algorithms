package recursion;

/*
Problem:

Example:

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

public class APowerB {
    public Integer calculate_power(Long a, Long b) {
        // Base Case
        if(b == 0) return 1;
        if(a == 0) return 0;

        // Recursive Case
        a = a % 1000000007;

        long result = calculate_power(a, b / 2);
        result = (result * result) % 1000000007;

        if(b % 2 != 0) result = (int)(result * a) % 1000000007;

        return (int) result;
    }
}

/*
Time Complexity:
Space Complexity:
 */