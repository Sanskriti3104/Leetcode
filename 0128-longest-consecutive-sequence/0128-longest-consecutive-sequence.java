class Solution {
    public int longestConsecutive(int[] nums) {
        // Return length of array if empty or contains only one element
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }

        //Sort the array
        Arrays.sort(nums);

        // Initialize counters for the current sequence and the longest sequence
        int count =1;
        int longestSeq = 0;

        // Iterate through the sorted array to find the longest consecutive sequence
        for(int i=1; i<nums.length; i++){

            //if current and previous elements are consecutive
            if(nums[i-1] + 1 == nums[i]){
                count++;
                longestSeq = Math.max(count,longestSeq);
            }
            // Skip duplicates
            else if(nums[i-1] == nums[i]){
                continue;
            }
            // Reset count if not consecutive
            else{      
                count = 1;
            }
        }

        // Return the longest sequence found, defaulting to 1 if no sequence found
        return (longestSeq == 0) ? 1 : longestSeq;
    }
}