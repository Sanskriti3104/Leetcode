class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        Arrays.sort(nums);

        int longestSequence = 1;
        int count = 0;
        int lastSmall = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(lastSmall == nums[i]-1){
                count++;
            }else if(lastSmall != nums[i]){
                count = 1;
            }

            longestSequence = Math.max(longestSequence,count);
            lastSmall = nums[i];
        }

        return longestSequence;
    }
}