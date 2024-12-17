class Solution {
    public int[] rearrangeArray(int[] nums) {
        //the array to store elements after rearranging
        int rearrangeNums[] = new int[nums.length];

        //pointers to locate positive and negative integers
        int pos = 0;
        int neg= 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                rearrangeNums[pos] = nums[i];
                pos = pos + 2;
            }else{
                rearrangeNums[neg] = nums[i];
                neg = neg + 2;
            }
        }

        //return modified array
        return rearrangeNums;
    }
}