class Solution {
    public void Reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        k = k % nums.length; // Handle cases where k > nums.length

        // Reverse first n-k elements
        Reverse(nums, 0, nums.length - k - 1);
        // Reverse last k elements
        Reverse(nums, nums.length - k, nums.length - 1);
        // Reverse whole array
        Reverse(nums, 0, nums.length - 1);
    }
}
