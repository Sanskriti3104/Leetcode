class Solution {
    public boolean check(int[] nums) {
        // Track the number of times the sorted order breaks
        int countBreak = 0;

        //Traverse through the array circularly and count break points 
        for(int i=0; i<nums.length; i++){
            int idx =(1+i)%nums.length;
            //If next element is greater than the current element - valid break point
            if(nums[i]>nums[idx]){
                countBreak++;
            }
        }

        //A valid sorted and rotated array can have at most one break point
        return countBreak <= 1;
    }
}
//Time Complexity - O(n)
//Space Complexity - O(1)