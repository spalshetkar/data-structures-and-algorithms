class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;        
        for(j = 0; j < nums.length; j++) {
            if(nums[j] == 0) break;
        }

        for(int i = j+1; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return;
    }
}