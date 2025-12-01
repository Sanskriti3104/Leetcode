class Solution {
    public void moveZeroes(int[] nums) {
         int i=0;

        while(i<nums.length){
            if(nums[i] == 0){
                break;
            }
            else i++;
        }

        for(int j=i+1; j<nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }

        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }
}