class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int n : nums) result ^= n;

        return result;
    }
}

/*
NOTE:
Intuition is this: a XOR a = 0 and a XOR 0 = a
So whichever number is left at the end, is the one which appears exactly once
*/

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/