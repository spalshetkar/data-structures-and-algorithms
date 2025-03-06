class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i <= n; i++) totalSum += i;

        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];

        return totalSum - sum;
    }
}