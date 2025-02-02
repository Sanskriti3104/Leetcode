class Solution {

    // Swap function
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse function
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: If no such element is found, reverse the array (last permutation case)
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Step 3: Find the smallest element in the right subarray that is larger than nums[idx]
        int swapIdx = -1;
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swapIdx = i;
                break;
            }
        }

        // Step 4: Swap the elements at idx and swapIdx
        swap(nums, idx, swapIdx);

        // Step 5: Reverse the subarray to the right of idx to get the next permutation
        reverse(nums, idx + 1, n - 1);
    }
}
