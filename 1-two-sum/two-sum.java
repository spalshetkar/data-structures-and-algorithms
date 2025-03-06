class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if(map.containsKey(remaining)) return new int[]{map.get(remaining), i};

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/