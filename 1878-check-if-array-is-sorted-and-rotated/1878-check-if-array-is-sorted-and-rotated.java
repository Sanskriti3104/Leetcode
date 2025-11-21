class Solution {
    public boolean check(int[] nums) {
        boolean flag = true;
        int pos = 0;

        for(int i =0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) {   
                pos = i+1;
                break;
            }
        }

        if( pos == 0 )  return flag;

        for(int i= pos; i< nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                flag = false;
                break;
            }
        }

        if(nums[0] < nums[nums.length -1 ]) flag = false;

        return flag;
    }
}