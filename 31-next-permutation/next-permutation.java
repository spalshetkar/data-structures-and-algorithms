class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;

        // Find the first dip from right to left
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            reverse(nums, 0);
            return;
        }

        // Swap the dip index with the next larger number from right to left
        for(int i = nums.length - 1; i >= index; i--) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        
        // Reverse the remaining array after the dip
        reverse(nums, index+1);

        return;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;

        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}