class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxCount = 0;
        int flipOnes = 0; // Tracks how many 0s are flipped

        while (right < nums.length) {
            // Expand the window
            if (nums[right] == 0) {
                flipOnes++;
            }

            // Shrink the window if we exceed k flips
            while (flipOnes > k) {
                if (nums[left] == 0) {
                    flipOnes--;
                }
                left++;
            }

            // Update max count of consecutive ones (including flipped zeros)
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }

        return maxCount;
    }
}
