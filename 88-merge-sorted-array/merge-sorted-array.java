class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;

        while(m > 0 && n > 0) {
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[k] = nums1[m - 1];
                m--;
                k--;
            }
            else {
                nums1[k] = nums2[n - 1];
                n--;
                k--;
            }
        }

        while(m > 0) {
            nums1[k] = nums1[m - 1];
            m--;
            k--;
        }
        while(n > 0) {
            nums1[k] = nums2[n - 1];
            n--;
            k--;
        }

        return;
    }
}

/*
Time Complexity: O(n + m)
Space Complexity: O(1)
*/