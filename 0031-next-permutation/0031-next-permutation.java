class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int left, int right, int[] nums) {
        while (left < right) {
            swap(left,right,nums);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int pivot = -1;

        for(int i = nums.length - 1; i>0; i--){
            if(nums[i] > nums[i-1]){
                pivot = i-1;
                break;
            }
        }

        if(pivot == -1){
            reverse(0,nums.length-1,nums);
            return;
        }

        int nextGreaterIndex = -1;

        for(int i = nums.length - 1; i>pivot; i--){
            if(nums[i] > nums[pivot]){
                nextGreaterIndex = i;
                break;
            }
        }

        swap(pivot, nextGreaterIndex, nums);
        reverse(pivot + 1, nums.length - 1, nums);
    }
}