class Solution {
    public int singleNumber(int[] nums) {
        int Ones = 0;
        int Twos = 0;

        for(int i=0; i<nums.length; i++){
            Ones = (Ones ^ nums[i]) & ~Twos;
            Twos = (Twos ^ nums[i]) & ~Ones;
        }

        return Ones;
    }
}