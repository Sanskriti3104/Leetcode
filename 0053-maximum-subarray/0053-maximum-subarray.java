class Solution {
    public int maxSubArray(int[] nums) {
        int MaxSum = Integer.MIN_VALUE;
        int currentSum =0;
        
        for(int i=0; i<nums.length; i++){
            currentSum += nums[i];
            MaxSum = Math.max(currentSum,MaxSum);

            if(currentSum < 0){
                currentSum = 0;
            }
        }

        return MaxSum;
    }
}