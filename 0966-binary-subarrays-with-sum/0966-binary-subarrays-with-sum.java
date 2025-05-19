class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left =0;
        int right =0;
        int count =0;
        int sum=0;

        while(left < nums.length){
            while(right<nums.length){
                sum = sum + nums[right];
                if(sum == goal){
                    count++;
                }else if(sum>goal){
                    break;
                }
                right++;
            }
            sum = 0;
            left++;
            right = left;
        }

        return count;
    }
}