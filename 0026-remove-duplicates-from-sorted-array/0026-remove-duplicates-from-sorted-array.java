class Solution {
    public int removeDuplicates(int[] nums) {
        //Two pointers
        int left =0;
        int right =1;

        while(right < nums.length){
            //Skip duplicate elements
            if(nums[left] == nums[right])   right++;
            //Place the next unique element at the write position
            else{
                left++;
                nums[left] = nums[right];
                right++;
            }
        }

        return left+1;
    }
}
//Time Complexity - O(N)
//Space Complexity - O(1)