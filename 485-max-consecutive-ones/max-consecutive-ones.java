class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
            else count++;
        }

        return Math.max(maxCount, count);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/