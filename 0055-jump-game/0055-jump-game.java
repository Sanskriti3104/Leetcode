class Solution {
    public boolean canJump(int[] nums) {
        //int currentIdx = 0;
        int lastIdx = nums.length - 1;
        int jump=0;

        for(int i=0; i<nums.length; i++){
            if(jump >= i)   jump = Math.max(jump,i + nums[i]);
        }

        return jump >= lastIdx;
        //while(currentIdx < nums.length && nums[currentIdx] != 0){
         //   if(currentIdx == lastIdx)   return true;
         //   currentIdx = currentIdx + nums[currentIdx];
        //}

        //return currentIdx >= lastIdx;
    }
}