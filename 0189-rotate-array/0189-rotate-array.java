class Solution {
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;     
        
        reverse(nums,0,nums.length -1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}