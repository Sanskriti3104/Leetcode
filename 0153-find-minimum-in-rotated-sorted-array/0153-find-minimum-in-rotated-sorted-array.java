class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high)/2;
            //if nums[low] <= nums[high] that means entire part is sorted 
            if(nums[low] <= nums[high]){
                min = Math.min(nums[low],min);
                break;
            }

            //left part is sorted
            if(nums[low] <= nums[mid]){
                min = Math.min(nums[low], min);
                low = mid + 1;
            }

            //right part is sorted
            else{
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }
        }

        return min;
    }
}