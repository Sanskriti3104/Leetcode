class Solution {
    public int[] rearrangeArray(int[] nums) {
       int result[] = new int[nums.length];
       int pos = 0, neg = 0;

       for(int i=0; i<nums.length; i++){
            if(i %2 == 0){
                while(nums[pos] <0){
                    pos++;
                }
                result[i] = nums[pos];
                pos++;  
            }else{
                while(nums[neg] >0){
                    neg++;
                }
                result[i] = nums[neg];
                neg++;
            }
       }

        return result;
    }
}